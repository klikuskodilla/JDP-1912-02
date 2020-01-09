package com.kodilla.ecommercee.domain.user;

import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityDto {
    private BigInteger id;
    private String name;
    private String surname;
    private String login;
    private String mail;
    private String password;
    private Integer sessionKey;
    private CartEntity cart;
    private List<OrderEntity> orders;

}
