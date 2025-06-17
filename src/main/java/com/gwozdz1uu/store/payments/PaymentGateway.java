package com.gwozdz1uu.store.payments;

import com.gwozdz1uu.store.orders.Order;

import java.util.Optional;


public interface PaymentGateway {
    CheckoutSession createCheckoutSession(Order order);
    Optional<PaymentResult> parseWebhookRequest(WebhookRequest request);
}
