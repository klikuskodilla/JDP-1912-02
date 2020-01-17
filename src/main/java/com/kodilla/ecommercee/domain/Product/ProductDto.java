package com.kodilla.ecommercee.domain.Product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.groups.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String description;
    private BigDecimal price;
    private String gorupName;


}
