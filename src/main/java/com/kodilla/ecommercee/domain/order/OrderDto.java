package com.kodilla.ecommercee.domain.order;

import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String adress;
    private Boolean isPaid;
    private Date created;
}
