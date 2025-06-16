package com.gwozdz1uu.store.payments;

import com.gwozdz1uu.store.entities.Order;

import java.util.Optional;


public interface PaymentGateway {
    CheckoutSession createCheckoutSession(Order order);
    Optional<PaymentResult> parseWebhookRequest(WebhookRequest request);
}
