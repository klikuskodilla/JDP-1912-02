package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.Product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GroupDto {
    private Long group_id;
    private String groupName;
    private List<ProductDto> products = new ArrayList<>();
}