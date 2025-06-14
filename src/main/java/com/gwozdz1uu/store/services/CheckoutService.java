package com.gwozdz1uu.store.services;

import com.gwozdz1uu.store.dtos.CheckoutRequest;
import com.gwozdz1uu.store.dtos.CheckoutResponse;
import com.gwozdz1uu.store.entities.Order;
import com.gwozdz1uu.store.exceptions.CartEmptyException;
import com.gwozdz1uu.store.exceptions.CartNotFoundException;
import com.gwozdz1uu.store.exceptions.PaymentException;
import com.gwozdz1uu.store.repositories.CartRepository;
import com.gwozdz1uu.store.repositories.OrderRepository;
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
}
