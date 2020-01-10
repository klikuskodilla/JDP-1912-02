package com.kodilla.ecommercee.controller.product;

import com.kodilla.ecommercee.domain.Product.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducs(){
        List<ProductDto> products = new ArrayList<>();
        products.add(new ProductDto(1L, "testDescription", new BigDecimal(10)));
        products.add(new ProductDto(2L, "testDescription2", new BigDecimal(10)));
        return products;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException{
        return new ProductDto(1L, "testGetProduct", new BigDecimal(15));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto){

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return new ProductDto(1L, "updateProduct", new BigDecimal(20));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId){
    }

}
