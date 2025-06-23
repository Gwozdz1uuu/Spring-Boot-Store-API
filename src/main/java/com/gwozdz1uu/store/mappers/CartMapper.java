package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.carts.CartDto;
import com.gwozdz1uu.store.carts.CartItemDto;
import com.gwozdz1uu.store.carts.CartProductDto;
import com.gwozdz1uu.store.carts.Cart;
import com.gwozdz1uu.store.carts.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartMapper {
    @Mapping(source="id", target = "id")
    @Mapping(source= "items", target="items")
    @Mapping(target="totalPrice",expression = "java(cart.getTotalPrice())")
//    CartDto toDto(Cart cart); //to sie psuje
    default CartDto toDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setId( cart.getId() );
        cartDto.setItems( cartItemSetToCartItemDtoList( cart.getItems() ) );

        cartDto.setTotalPrice( cart.getTotalPrice() );

        return cartDto;
    }
    private List<CartItemDto> cartItemSetToCartItemDtoList(Set<CartItem> set) {
        if ( set == null ) {
            return null;
        }

        List<CartItemDto> list = new ArrayList<CartItemDto>( set.size() );
        for ( CartItem cartItem : set ) {
            list.add( toDto( cartItem ) );
        }

        return list;
    }


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
