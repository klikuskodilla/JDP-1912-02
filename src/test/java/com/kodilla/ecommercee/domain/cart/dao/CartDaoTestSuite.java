package com.kodilla.ecommercee.domain.cart.dao;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.dao.ProductDao;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.user.UserEntity;
import com.kodilla.ecommercee.domain.user.dao.UserEntityDao;
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
public class CartDaoTestSuite {
    @Autowired
    private CartEntityDao cartEntityDao;
    @Autowired
    private UserEntityDao userDao;
    @Autowired
    private ProductDao productDao;

    private static final String NAME = "John";
    private static final String SURNAME = "Rambo";
    private static final String LOGIN = "Test_Login";
    private static final String MAIL = "mail@test.com";
    private static final String PASSWORD = "testpassword";
    private static final Integer SESSION_KEY = 12345;

    @Test
    public void testCartUserSave() {

        //Given
        CartEntity cart = new CartEntity();

        UserEntity user = new UserEntity(NAME, SURNAME, LOGIN, MAIL, PASSWORD);
        user.setSessionKey(SESSION_KEY);

        //When
        user.setCart(cart);
        userDao.save(user);

        //Then
        Long id = cart.getId();
        Optional<CartEntity> readCart = cartEntityDao.findById(id);
        Assert.assertTrue(readCart.isPresent());
        Assert.assertNotEquals(Optional.of(0), readCart.get().getUser().getId());

        //Clean up
        try {
            cartEntityDao.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }

        Optional<UserEntity> readUser = userDao.findById(user.getId());
        try {
            userDao.deleteById(readUser.get().getId());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testCartProductsSave() {
        //Given
        CartEntity cart1 = new CartEntity();
        CartEntity cart2 = new CartEntity();

        Product product1 = new Product("wireless headphones","description1", new BigDecimal(10));
        Product product2 = new Product("headphones","description2", new BigDecimal(5));
        Product product3 = new Product("keyboard","description3", new BigDecimal(15));

        cart1.getProducts().add(product1);
        cart1.getProducts().add(product2);
        cart1.getProducts().add(product3);
        product1.getCarts().add(cart1);
        product2.getCarts().add(cart1);
        product3.getCarts().add(cart1);

        cart2.getProducts().add(product1);
        cart2.getProducts().add(product3);
        product1.getCarts().add(cart2);
        product3.getCarts().add(cart2);

        //When
        cartEntityDao.save(cart1);
        cartEntityDao.save(cart2);

        Optional<CartEntity> readCart1 = cartEntityDao.findById(cart1.getId());
        Optional<CartEntity> readCart2 = cartEntityDao.findById(cart2.getId());

        Optional<Product> readProduct1 = productDao.findById(product1.getId());
        Optional<Product> readProduct2 = productDao.findById(product2.getId());
        Optional<Product> readProduct3 = productDao.findById(product3.getId());

        //Then
        Assert.assertTrue(readCart1.isPresent());
        Assert.assertTrue(readCart2.isPresent());

        Assert.assertNotEquals(Optional.of(0L), readProduct1.get().getId());
        Assert.assertNotEquals(Optional.of(0L), readProduct2.get().getId());
        Assert.assertNotEquals(Optional.of(0L), readProduct3.get().getId());


        //Clean up
        try {
            cartEntityDao.deleteById(readCart1.get().getId());
            cartEntityDao.deleteById(readCart2.get().getId());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            productDao.deleteById(readProduct1.get().getId());
            productDao.deleteById(readProduct2.get().getId());
            productDao.deleteById(readProduct3.get().getId());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

