package com.kodilla.ecommercee.domain.cart;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private BigDecimal cost;
    private List<Product> products;
    private UserEntity user;

}
