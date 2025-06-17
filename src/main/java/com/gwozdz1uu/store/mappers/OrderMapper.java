package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.orders.OrderDto;
import com.gwozdz1uu.store.orders.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
//    default OrderDto toDto(Order order) {return null;}
}
