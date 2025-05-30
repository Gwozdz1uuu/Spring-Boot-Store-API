package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.dtos.CartDto;
import com.gwozdz1uu.store.entities.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(source="id", target = "id")
    CartDto toDto(Cart cart);
}
