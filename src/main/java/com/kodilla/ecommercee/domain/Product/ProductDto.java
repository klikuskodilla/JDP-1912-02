package com.kodilla.ecommercee.domain.Product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.groups.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String description;
    private BigDecimal price;
}
