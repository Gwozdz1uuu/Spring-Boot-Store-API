package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.products.ProductDto;
import com.gwozdz1uu.store.products.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface ProductMapper {
    default ProductDto toDto(Product product) {
        if (product == null) return null;
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId().longValue()
        );
    }
//    @Mapping(source = "category.id", target="categoryId")
//    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);




    @Mapping(target="id", ignore = true)
    void updateProduct(ProductDto productDto,@MappingTarget Product product); //to sie psuje
//    default void updateProduct(ProductDto productDto, Product product) {
//    }
}
