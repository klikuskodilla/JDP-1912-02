package com.kodilla.ecommercee.domain.cart;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.dao.ProductDao;
import com.kodilla.ecommercee.domain.cart.dao.CartEntityDao;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import com.kodilla.ecommercee.domain.order.dao.OrderDao;
import com.kodilla.ecommercee.domain.user.UserEntity;
import com.kodilla.ecommercee.domain.user.dao.UserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartDBService {
    @Autowired
    private CartEntityDao cartEntityDao;
    @Autowired
    private UserEntityDao userEntityDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;

    public CartEntity saveCart(final  CartEntity cartEntity) {
        return cartEntityDao.save(cartEntity);
    }

    public Optional<CartEntity> getCard(final Long cartID) {
        return cartEntityDao.findById(cartID);
    }

    public Optional<UserEntity> getUser(final Long userID) {
        return userEntityDao.findById(userID);
    }

    public Optional<Product> getProduct(final Long productID) {
        return productDao.findById(productID);
    }

    public void saveOrder(final OrderEntity orderEntity) {
        orderDao.save(orderEntity);
    }
}
