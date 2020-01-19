package com.kodilla.ecommercee.controller.order;

import com.kodilla.ecommercee.controller.product.ProductNotFoundException;
import com.kodilla.ecommercee.controller.user.UserNotFoundException;
import com.kodilla.ecommercee.domain.cart.dao.CartEntityDao;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import com.kodilla.ecommercee.domain.user.UserEntity;
import com.kodilla.ecommercee.domain.user.dao.UserEntityDao;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderMapper  {

    @Autowired
    UserEntityDao userDao;

    @Autowired
    CartEntityDao cartDao;

    public OrderEntity mapToOrder(final OrderDto orderDto) throws ProductNotFoundException {
        OrderEntity orderEntity = new OrderEntity(
                orderDto.getAddress()
        );
        orderEntity.setPaid(orderDto.getIsPaid());
        orderEntity.setUser(userDao.findById(orderDto.getUserId()).orElseThrow(ProductNotFoundException::new));
        orderEntity.setCart(cartDao.findById(orderDto.getCartId()).orElse(null));

        return orderEntity;
    }

    public OrderDto orderDtoToMap(final OrderEntity orderEntity) {
        return new OrderDto(
                orderEntity.getId(),
                orderEntity.getAdress(),
                orderEntity.getPaid(),
                orderEntity.getCreated(),
                orderEntity.getUser().getId(),
                orderEntity.getCart().getId(),
                orderEntity.getCart().getCost()
        );
    }
}
