package com.kodilla.ecommercee.domain.user.dao;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import com.kodilla.ecommercee.domain.user.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite {
    @Autowired
    private UserEntityDao userDao;
    private static final String NAME = "John";
    private static final String SURNAME = "Rambo";
    private static final String LOGIN = "Test_Login";
    private static final String MAIL = "mail@test.com";
    private static final String PASSWORD = "testpassword";
    private static final Integer SESSION_KEY = 12345;

    @Test
    public void testUserDaoSave(){
        //Given
        UserEntity user1 = new UserEntity(NAME, SURNAME, LOGIN, MAIL, PASSWORD);
        user1.setSessionKey(SESSION_KEY);

        //When
        userDao.save(user1);

        //Then
        Long id = user1.getId();
        Optional<UserEntity> readUser = userDao.findById(id);
        Assert.assertTrue(readUser.isPresent());
        Assert.assertEquals(readUser.get().getLoggedIn(), false);


        //CleanUp
        //userDao.deleteById(id);
    }

    @Test
    public void testUserDaoSaveWithOrderAndCart(){
        //CleanBefore
        //userDao.deleteAll();

        //Given
        UserEntity user = new UserEntity(NAME, SURNAME, "Test Login 2", "mail2@test.com", PASSWORD);
        user.setSessionKey(SESSION_KEY);
        CartEntity cart = new CartEntity();
        cart.setCost(new BigDecimal(30.99));
        user.setCart(cart);
        cart.setUser(user);
        OrderEntity order1 = new OrderEntity("Adress 1");
        OrderEntity order2 = new OrderEntity("Adress 2");
        user.getOrders().add(order1);
        user.getOrders().add(order2);
        order1.setUser(user);
        order2.setUser(user);
        user.setLoggedIn(true);

        //When
        userDao.save(user);
        Long id = user.getId();
        Optional<UserEntity> readUser = userDao.findById(id);
        String readOrder1Adress = readUser.get().getOrders().get(0).getAdress();
        String readOrder2Adress = readUser.get().getOrders().get(1).getAdress();
        BigDecimal readCart = readUser.get().getCart().getCost();
        String readCartUser = cart.getUser().getLogin();



        //Then
        Assert.assertTrue(readUser.isPresent());
        Assert.assertEquals(readUser.get().getId(), user.getId());
        Assert.assertEquals(readOrder1Adress, "Adress 1");
        Assert.assertEquals(readOrder2Adress, "Adress 2");
        Assert.assertEquals(BigDecimal.valueOf(30.99), readCart);
        Assert.assertEquals(readCartUser, "Test Login 2");
        Assert.assertEquals(readUser.get().getId(), user.getId());
        Assert.assertEquals(readUser.get().getName(), "John");
        Assert.assertEquals(readUser.get().getSurname(), "Rambo");
        Assert.assertEquals(readUser.get().getOrders().get(0).getUser().getId(), user.getId());
        Assert.assertEquals(readUser.get().getOrders().get(1).getUser().getId(), user.getId());
        Assert.assertEquals(readUser.get().getCart().getUser().getId(), user.getId());
        Assert.assertEquals(readUser.get().getLoggedIn(), true);




        //CleanUp
        //userDao.deleteById(id);
    }
}
