package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.Product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class GroupDto {
    private Long groupId;
    private String groupName;
    private List<ProductDto> productsGroup;
}