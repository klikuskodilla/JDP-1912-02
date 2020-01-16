package com.kodilla.ecommercee.controller.cart;

import com.kodilla.ecommercee.domain.Product.ProductDto;
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
        products.add(new ProductDto(1L, "item1", new BigDecimal(5)));
        products.add(new ProductDto(2L, "item1", new BigDecimal(8)));
        return products;
    }

    @PutMapping("/{cartID}/addProducts/{productID}")
    public Map<String,String> addProduct(@PathVariable Long cartID, @PathVariable Long productID) throws NotFoundException {
        Map<String, String> productDetails = new HashMap<>();
        productDetails.put("item1", "price1");
        productDetails.put("item2", "price2");
        productDetails.put("item2", "price3");
        return productDetails;
    }

    @DeleteMapping("/{cartID}/deleteProduct/{productID}")
    public void deleteProduct(@PathVariable Long cartID, @PathVariable Long productID) throws NotFoundException {

    }

    @PostMapping("/{cardID}/createOrder")
    public OrderDto createOrder(@PathVariable Long cardID, @RequestParam("address") String address) throws NotFoundException {
        return new OrderDto(1L, "address1", false, new Date());
    }

}
