package com.kodilla.ecommercee.controller.cart;

import com.kodilla.ecommercee.domain.Product.ProductDto;
import com.kodilla.ecommercee.domain.cart.CartDto;
import com.kodilla.ecommercee.domain.order.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping("/createCart/{userID}")
    public void createCart(@PathVariable Long userID) throws NotFoundException {

    }

    @GetMapping("/{cartID}/getProducts")
    public List<ProductDto> getProducts(@PathVariable Long cartID) throws NotFoundException {
        List<ProductDto> products = new ArrayList<>();
        products.add(new ProductDto(1L, "item1", new BigDecimal(5),"groupName1"));
        products.add(new ProductDto(2L, "item1", new BigDecimal(8),"groupName1"));
        return products;
    }

    @PutMapping("/{cartID}/addProducts/{productID}")
    public CartDto addProduct(@PathVariable Long cartID, @PathVariable Long productID) throws NotFoundException {
        CartDto cartDto = new CartDto();
        cartDto.setId(1L);
        cartDto.setCost(new BigDecimal(15));
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto1 = new ProductDto(1L, "item1", new BigDecimal(6),"groupName1");
        ProductDto productDto2 = new ProductDto(2L, "item2", new BigDecimal(9),"groupName1");
        productDtoList.add(productDto1);
        productDtoList.add(productDto2);
        cartDto.setProductDetails(productDtoList);
        return cartDto;
    }

    @DeleteMapping("/{cartID}/deleteProduct/{productID}")
    public void deleteProduct(@PathVariable Long cartID, @PathVariable Long productID) throws NotFoundException {

    }

    @PostMapping("/{cardID}/createOrder")
    public OrderDto createOrder(@PathVariable Long cardID, @RequestParam("address") String address) throws NotFoundException {
        return new OrderDto(1L, "address1", false, new Date(), 1L, 1L, new BigDecimal(100));
    }

}
