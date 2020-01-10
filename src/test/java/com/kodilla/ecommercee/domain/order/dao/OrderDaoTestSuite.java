package com.kodilla.ecommercee.domain.order.dao;

import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import com.kodilla.ecommercee.domain.user.UserEntity;
import com.kodilla.ecommercee.domain.user.UserEntityDto;
import com.kodilla.ecommercee.domain.user.dao.UserEntityDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTestSuite {
    @Autowired
    private OrderDao orderDao;

    private static final String ADRESS = "Test adress 1";

    @Test
    public void testOrderDaoSave(){

        //Given
        OrderEntity order = new OrderEntity(ADRESS);

        //When
        orderDao.save(order);

        //Then
        Long id = order.getId();
        Optional<OrderEntity> readOrder = orderDao.findById(id);
        Assert.assertTrue(readOrder.isPresent());
        System.out.println(readOrder.get().getId() + " | " + readOrder.get().getAdress() + " | " + readOrder.get().getPaid() + " | " + readOrder.get().getCreated());

        //CleanUp
        orderDao.deleteById(id);
    }

    @Test
    public void testOrderEntityWithOtherEntities() {

        //Given
            OrderEntity order = new OrderEntity(ADRESS);

            UserEntity user = new UserEntity("James", "Bond", "007", "MI6@england.pl", "ABC123" );

            CartEntity cart = new CartEntity();
            cart.setCost(new BigDecimal(432.32));

            order.setUser(user);
            user.getOrders().add(order);

            order.setCart(cart);
            cart.setOrder(order);

        //When
            orderDao.save(order);
            Optional<OrderEntity> readOrder = orderDao.findById(order.getId());
        //Then

            Assert.assertTrue(readOrder.isPresent());

            Assert.assertEquals("Test adress 1", readOrder.get().getAdress());
            Assert.assertEquals("Bond", readOrder.get().getUser().getSurname());
            Assert.assertEquals("007", readOrder.get().getUser().getLogin());
            Assert.assertEquals("James", readOrder.get().getUser().getName());
            Assert.assertEquals("MI6@england.pl", readOrder.get().getUser().getMail());
            Assert.assertEquals(BigDecimal.valueOf(432.32), readOrder.get().getCart().getCost());

        //CleanUp
            try {
                orderDao.deleteById(readOrder.get().getId());
            } catch (Exception e) {
                System.out.println(e);
            }
    }



}
