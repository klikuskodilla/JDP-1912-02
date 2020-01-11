package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.cart.*;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import com.kodilla.ecommercee.domain.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartDBService cartDBService;

    @PostMapping("/createCart/{userID}")
    public void createCart(@PathVariable Long userID) throws NotFoundException{
        CartEntity cart = new CartEntity();
        UserEntity userEntity = cartDBService.getUser(userID).orElseThrow(NotFoundException::new);
        cart.setUser(userEntity);
        userEntity.setCart(cart);
        cartDBService.saveCart(cart);

    }

    @GetMapping("/{cartID}/getProducts")
    public List<ProductDtoToCart> getProducts(@PathVariable Long cartID) throws NotFoundException {
        CartEntity cart = cartDBService.getCard(cartID).orElseThrow(NotFoundException::new);
        return cartMapper.mapToProductDtoList(cart.getProducts());
    }

    @PutMapping("/{cartID}/addProducts/{productID}")
    public void addProduct(@PathVariable Long cartID, @PathVariable Long productID) throws NotFoundException{
        CartEntity cart = cartDBService.getCard(cartID).orElseThrow(NotFoundException::new);
        Product product = cartDBService.getProduct(productID).orElseThrow(NotFoundException::new);
        cart.getProducts().add(product);
        cartDBService.saveCart(cart);
    }

    @DeleteMapping("/{cartID}/deleteProduct/{productID}")
    public void deleteProduct(@PathVariable Long cartID, @PathVariable Long productID) throws NotFoundException{
        CartEntity cart = cartDBService.getCard(cartID).orElseThrow(NotFoundException::new);
        Product product = cartDBService.getProduct(productID).orElseThrow(NotFoundException::new);
        cart.getProducts().remove(product);
        cartDBService.saveCart(cart);
    }

    @PostMapping("/{cardID}/createOrder")
    public void createOrder(@PathVariable Long cardID,@RequestParam("address") String address) throws NotFoundException{
        CartEntity cart = cartDBService.getCard(cardID).orElseThrow(NotFoundException::new);
        OrderEntity order = new OrderEntity(address);
        order.setCart(cart);
        order.setUser(cart.getUser());
        System.out.println(address);
        cartDBService.saveOrder(order);
    }

}
