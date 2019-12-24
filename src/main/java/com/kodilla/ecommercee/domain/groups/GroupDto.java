package com.kodilla.ecommercee.domain.groups;

<<<<<<< HEAD
import com.kodilla.ecommercee.domain.Product.ProductDto;
=======
import com.kodilla.ecommercee.domain.products.ProductDto;
>>>>>>> origin/JDP191202-13
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupDto {
    private Long groupId;
    private String groupName;
    private List<ProductDto> productsGroup = new ArrayList<>();
}