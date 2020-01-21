package com.kodilla.ecommercee.controller.cart;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.dao.ProductDao;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.cart.dao.CartEntityDao;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import com.kodilla.ecommercee.domain.order.dao.OrderDao;
import com.kodilla.ecommercee.domain.user.UserEntity;
import com.kodilla.ecommercee.domain.user.dao.UserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DBCartService {
    @Autowired
    private CartEntityDao saveCartRepository;
    @Autowired
    private CartEntityDao getCartRepository;
    @Autowired
    private UserEntityDao getUserRepository;
    @Autowired
    private ProductDao getProductRepository;
    @Autowired
    private OrderDao saveOrderRepository;


    public void saveCart(final Long userID) {
        CartEntity cart = new CartEntity();
        UserEntity user = getUserRepository.findById(userID).get();
        cart.setUser(user);
        user.setCart(cart);
        cart.setCost(BigDecimal.ZERO);
        saveCartRepository.save(cart);
    }

    public List<Product> getProducts(final Long cartID) {
        CartEntity cart = getCartRepository.findById(cartID).get();
        return cart.getProducts();
    }

    public CartEntity addProduct(Long cartID, Long productID) {
        CartEntity cart = getCartRepository.findById(cartID).get();
        Product product = getProductRepository.findById(productID).get();
        cart.getProducts().add(product);
        cart.setCost(cart.getCost().add(product.getPrice()));
        saveCartRepository.save(cart);
        return cart;
    }

    public CartEntity deleteProduct(Long cartID, Long productID) {
        CartEntity cart = getCartRepository.findById(cartID).get();
        Product product = getProductRepository.findById(productID).get();
        cart.getProducts().remove(product);
        cart.setCost(cart.getCost().subtract(product.getPrice()));
        saveCartRepository.save(cart);
        return cart;
    }

    public OrderEntity createOrder(Long cartID, String address) {
        CartEntity cart = getCartRepository.findById(cartID).get();
        OrderEntity order = new OrderEntity(address);
        order.setCart(cart);
        order.setUser(cart.getUser());
        saveOrderRepository.save(order);
        return order;
    }
}
