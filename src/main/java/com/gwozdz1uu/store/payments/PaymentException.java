package com.gwozdz1uu.store.payments;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymentException extends RuntimeException {

    public PaymentException(String s) {
        super(s);
    }
}
