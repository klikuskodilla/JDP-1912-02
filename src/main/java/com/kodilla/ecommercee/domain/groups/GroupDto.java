package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupDto {
    private Long id;
    private String groupName;
   // private List<ProductDto> products = new ArrayList<>();
}