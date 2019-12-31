package com.kodilla.ecommercee.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String description;
    private BigDecimal price;
  /*  private Group group;
    List<CartEntity> carts;*/
}
