package com.kodilla.ecommercee.controller.cart;

import com.kodilla.ecommercee.controller.order.OrderMapper;
import com.kodilla.ecommercee.controller.product.ProductMapper;
import com.kodilla.ecommercee.domain.Product.ProductDto;
import com.kodilla.ecommercee.domain.cart.CartDto;
import com.kodilla.ecommercee.domain.order.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @Autowired
    private DBCartService cartService;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/createCart/{userID}")
    public void createCart(@PathVariable Long userID) throws NotFoundException {
        cartService.saveCart(userID);
    }

    @GetMapping("/{cartID}/getProducts")
    public List<ProductDto> getProducts(@PathVariable Long cartID) throws NotFoundException {
        return productMapper.mapToProductDtoList(cartService.getProducts(cartID));
    }

    @PutMapping("/{cartID}/addProducts/{productID}")
    public CartDto addProduct(@PathVariable Long cartID, @PathVariable Long productID) throws NotFoundException {
        return cartMapper.mapToCartDto(cartService.addProduct(cartID, productID));
    }

    @DeleteMapping("/{cartID}/deleteProduct/{productID}")
    public CartDto deleteProduct(@PathVariable Long cartID, @PathVariable Long productID) throws NotFoundException {
        return cartMapper.mapToCartDto(cartService.deleteProduct(cartID, productID));
    }

    @PostMapping("/{cartID}/createOrder")
    public OrderDto createOrder(@PathVariable Long cartID, @RequestParam("address") String address) throws NotFoundException {
        return orderMapper.orderDtoToMap(cartService.createOrder(cartID, address));
    }

}
