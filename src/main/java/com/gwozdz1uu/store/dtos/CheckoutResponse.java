package com.gwozdz1uu.store.dtos;

import com.gwozdz1uu.store.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CheckoutResponse {
    private Long orderId;
    private String checkoutUrl;

    public CheckoutResponse(Long orderId, String checkoutUrl) {
        this.orderId = orderId;
        this.checkoutUrl = checkoutUrl;
    }
}
