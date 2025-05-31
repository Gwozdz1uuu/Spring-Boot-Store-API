package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.dtos.CartDto;
import com.gwozdz1uu.store.dtos.CartItemDto;
import com.gwozdz1uu.store.dtos.CartProductDto;
import com.gwozdz1uu.store.entities.Cart;
import com.gwozdz1uu.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartMapper {
    @Mapping(source="id", target = "id")
    CartDto toDto(Cart cart);

//    CartItemDto toDto(CartItem cartItem);


    default CartItemDto toDto(CartItem cartItem) {
        if (cartItem == null) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        var price = cartItem.getProduct().getPrice();
        var quantity = cartItem.getQuantity();

        // Map nested product manually
        if (cartItem.getProduct() != null) {
            CartProductDto productDto = new CartProductDto();
            productDto.setId(cartItem.getProduct().getId());
            productDto.setName(cartItem.getProduct().getName());
            productDto.setPrice(price);
            cartItemDto.setProduct(productDto);
        }

        cartItemDto.setQuantity(quantity);
        cartItemDto.setTotalPrice(cartItem.getTotalPrice());

        return cartItemDto;
    }

}
