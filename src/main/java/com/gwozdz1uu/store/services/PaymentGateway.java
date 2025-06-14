package com.gwozdz1uu.store.services;

import com.gwozdz1uu.store.entities.Order;


public interface PaymentGateway {
    CheckoutSession createCheckoutSession(Order order);
}
