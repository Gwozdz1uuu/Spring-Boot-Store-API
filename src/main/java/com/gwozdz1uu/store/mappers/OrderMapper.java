package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.orders.*;
import com.gwozdz1uu.store.products.Product;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface OrderMapper {
//    OrderDto toDto(Order order);
    default OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        if ( order.getStatus() != null ) {
            orderDto.setStatus( order.getStatus().name() );
        }
        orderDto.setCreatedAt( order.getCreatedAt() );
        orderDto.setItems( orderItemSetToOrderItemDtoList( order.getItems() ) );
        orderDto.setTotalPrice( order.getTotalPrice() );

        return orderDto;
    }
    private List<OrderItemDto> orderItemSetToOrderItemDtoList(Set<OrderItem> set) {
        if ( set == null ) {
            return null;
        }

        List<OrderItemDto> list = new ArrayList<OrderItemDto>( set.size() );
        for ( OrderItem orderItem : set ) {
            list.add( orderItemToOrderItemDto( orderItem ) );
        }

        return list;
    }
    private OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setProduct( productToOrderProductDto( orderItem.getProduct() ) );
        if ( orderItem.getQuantity() != null ) {
            orderItemDto.setQuantity( orderItem.getQuantity() );
        }
        orderItemDto.setTotalPrice( orderItem.getTotalPrice() );

        return orderItemDto;
    }
    private OrderProductDto productToOrderProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        OrderProductDto orderProductDto = new OrderProductDto();

        orderProductDto.setId( product.getId() );
        orderProductDto.setName( product.getName() );
        orderProductDto.setPrice( product.getPrice() );

        return orderProductDto;
    }
}
