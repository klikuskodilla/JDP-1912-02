package com.kodilla.ecommercee.controller.order;

import com.kodilla.ecommercee.domain.order.OrderEntity;
import com.kodilla.ecommercee.domain.order.dao.OrderDao;
import com.kodilla.ecommercee.domain.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbOrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderMapper orderMapper;

    public List<OrderEntity> getOrders() {
        return orderDao.findAll();
    }

    public OrderEntity getOrder(final Long id) throws OrderNotFoundException {
        return orderDao.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public OrderEntity saveOrder(OrderEntity orderEntity) {
        return orderDao.save(orderEntity);
    }

    public void deleteOrder(final Long id) {
        UserEntity user = orderDao.findById(id).get().getUser();
        user.getOrders().remove(orderDao.findById(id).get());
        orderDao.deleteById(id);
    }
}
