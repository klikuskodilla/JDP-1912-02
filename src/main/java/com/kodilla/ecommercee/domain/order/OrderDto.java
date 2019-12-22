package com.kodilla.ecommercee.domain.order;

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
    private UserEntity user;
    private CartEntity cart;


}
