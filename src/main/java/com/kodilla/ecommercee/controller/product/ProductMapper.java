package com.kodilla.ecommercee.controller.product;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.ProductDto;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    @Autowired
    private GroupDao groupDao;

    public Product mapToProduct(final ProductDto productDto){
        Product product = new Product(
                productDto.getDescription(),
                productDto.getPrice()
        );
        product.setId(productDto.getId());
        product.setGroup(new Group(productDto.getGorupName()));

        return product;
    }

    public ProductDto mapToProductDto(final Product product){
        return new ProductDto(
                product.getId(),
                product.getDescription(),
                product.getPrice(),
                product.getGroup().getGroupName()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList){
        return productList.stream()
                .map(t -> new ProductDto(t.getId(), t.getDescription(),t.getPrice(), t.getGroup().getGroupName()))
                .collect(Collectors.toList());
    }
}
