package com.kodilla.ecommercee.domain.cart;

import com.kodilla.ecommercee.domain.Product.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    public List<ProductDtoToCart> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(t -> new ProductDtoToCart(
                        t.getId(),
                        t.getDescription(),
                        t.getPrice()))
                .collect(Collectors.toList());
    }

}