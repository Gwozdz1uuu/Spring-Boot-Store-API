package com.gwozdz1uu.store.payments;

import com.gwozdz1uu.store.orders.Order;
import com.gwozdz1uu.store.carts.CartEmptyException;
import com.gwozdz1uu.store.carts.CartNotFoundException;
import com.gwozdz1uu.store.carts.CartRepository;
import com.gwozdz1uu.store.orders.OrderRepository;
import com.gwozdz1uu.store.auth.AuthService;
import com.gwozdz1uu.store.carts.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final CartService cartService;
    private final PaymentGateway paymentGateway;


    @Transactional
    public CheckoutResponse checkout(CheckoutRequest checkoutRequest){
        var cart = cartRepository.getCartWithItems(checkoutRequest.getCartId()).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }

        if(cart.isEmpty()){
            throw new CartEmptyException();
        }

        var order = Order.fromCart(cart,authService.getCurrentUser());

        orderRepository.save(order);

        try {
            var session = paymentGateway.createCheckoutSession(order);

            cartService.clearCart(cart.getId());
            return new CheckoutResponse(order.getId(), session.getCheckoutUrl());
        }
        catch (PaymentException e) {
            System.out.println(e.getMessage());
            orderRepository.delete(order);
            throw e;
        }
    }

    public void handleWebhookEvent(WebhookRequest request){
        paymentGateway
                .parseWebhookRequest(request)
                .ifPresent(paymentResult -> {
                    var order = orderRepository.findById(paymentResult.getOrderId()).orElseThrow();
                    order.setStatus(paymentResult.getPaymentStatus());
                    orderRepository.save(order);
                });
    }
}
