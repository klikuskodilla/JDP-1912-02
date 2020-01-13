package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class GroupDto {
    private Long group_id;
    private String groupName;
    private List<ProductDto> products = new ArrayList<>();

   
    public GroupDto(long group_id, String groupName, ProductDto productDto) {
    }

    public GroupDto(Long group_id, String groupName, List<Product> products) {
    }
}