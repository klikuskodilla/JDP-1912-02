package com.kodilla.ecommercee.controller.order;

import com.kodilla.ecommercee.controller.user.UserNotFoundException;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.cart.dao.CartEntityDao;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import com.kodilla.ecommercee.domain.order.dao.OrderDao;
import com.kodilla.ecommercee.domain.user.dao.UserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper  {

    @Autowired
    UserEntityDao userDao;

    @Autowired
    CartEntityDao cartDao;

    @Autowired
    OrderDao orderDao;

    public OrderEntity mapToOrder(final OrderDto orderDto) throws UserNotFoundException {

        if(orderDao.findById(orderDto.getId()).isPresent()) {
            OrderEntity orderEntity = orderDao.findById(orderDto.getId()).get();
            orderEntity.setAdress(orderDto.getAddress());
            orderEntity.setPaid(orderDto.getIsPaid());
            orderEntity.setUser(userDao.findById(orderDto.getUserId()).orElseThrow(UserNotFoundException::new));
            orderEntity.setCart(cartDao.findById(orderDto.getCartId()).orElse(new CartEntity()));
            return orderEntity;
        }else {
            OrderEntity orderEntity = new OrderEntity(
                    orderDto.getAddress()
            );
            orderEntity.setPaid(orderDto.getIsPaid());
            orderEntity.setUser(userDao.findById(orderDto.getUserId()).orElseThrow(UserNotFoundException::new));
            orderEntity.setCart(cartDao.findById(orderDto.getCartId()).orElse(new CartEntity()));
            return orderEntity;
        }
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

    public List<OrderDto> mapToOrderDtoList(final List<OrderEntity> orderList) {
        return orderList.stream()
                .map(t -> new OrderDto(t.getId(), t.getAdress(), t.getPaid(), t.getCreated(), t.getUser().getId(), t.getCart().getId(), t.getCart().getCost()))
                .collect(Collectors.toList());
    }
}