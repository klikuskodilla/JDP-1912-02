package com.kodilla.ecommercee.domain.order.dao;

import com.kodilla.ecommercee.domain.order.OrderEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTestSuite {
    @Autowired
    private OrderDao orderDao;
    private static final String ADRESS = "Test adress 1";
    //private static final Boolean PAYMENT_STATUS = false;


    @Test
    public void testContextLoader(){

    }

    @Test
    public void testOrderDaoSave(){

        //Given
        OrderEntity order = new OrderEntity(ADRESS);
        order.setCreated(new Date());

        //When
        orderDao.save(order);

        //Then
        Long id = order.getId();
        Optional<OrderEntity> readOrder = orderDao.findById(id);
        Assert.assertTrue(readOrder.isPresent());
        System.out.println(readOrder.get().getId() + " | " + readOrder.get().getAdress() + " | " + readOrder.get().getPaid() + " | " + readOrder.get().getCreated());

        //CleanUp
        //orderDao.deleteById(id);
    }



}
