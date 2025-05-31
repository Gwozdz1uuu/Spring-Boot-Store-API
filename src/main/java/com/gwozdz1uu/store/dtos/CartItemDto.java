package com.gwozdz1uu.store.dtos;


import com.gwozdz1uu.store.entities.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private CartProductDto product;
    private int quantity;
    private BigDecimal totalPrice;
}
