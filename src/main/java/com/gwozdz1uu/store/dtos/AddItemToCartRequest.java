package com.gwozdz1uu.store.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class AddItemToCartRequest {
    @NotNull
    private Long productId;
}
