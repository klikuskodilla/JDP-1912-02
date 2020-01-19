package com.kodilla.ecommercee.controller.cart;

import com.kodilla.ecommercee.domain.Product.ProductDto;
import com.kodilla.ecommercee.domain.cart.CartDto;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartDto mapToCartDto(final CartEntity cartEntity) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cartEntity.getId());
        cartDto.setCost(cartEntity.getCost());
        List<ProductDto> productDtoList = cartEntity.getProducts().stream()
                .map(t -> new ProductDto(t.getId(), t.getDescription(),t.getPrice(), t.getGroup().getGroupName()))
                .collect(Collectors.toList());
        cartDto.setProductDetails(productDtoList);
        return cartDto;
    }
}