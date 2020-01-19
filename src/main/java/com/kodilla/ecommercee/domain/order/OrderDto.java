package com.kodilla.ecommercee.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String address;
    private Boolean isPaid;
    private Date created;
    private Long userId;
    private Long cartId;
    private BigDecimal cost;
}
