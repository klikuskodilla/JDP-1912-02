package com.kodilla.ecommercee.domain.product.dao;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.dao.ProductDao;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.groups.Group;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testProductDaoSave() {

        //Given
        Product testProduct = new Product("Test Description", new BigDecimal(123.5));

        //When
        productDao.save(testProduct);
        Long productId = testProduct.getId();

        //Then
        Optional<Product> readProduct = productDao.findById(productId);
        Assert.assertTrue(readProduct.isPresent());

        //CleanUp
        try {
            productDao.deleteById(productId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testProductEntityWithOtherEntities() {

        //Given
        Product testProduct1 = new Product("Test Description with other Entities", new BigDecimal(123.5));
        Product testProduct2 = new Product("Test no. 2 with other Entities", new BigDecimal(1500));
        Group testGroup1 = new Group("Spozywcze");
        Group testGroup2 = new Group("AGD");

        List<CartEntity> testCartList1 = new ArrayList<>();
        testCartList1.add(new CartEntity());
        testProduct1.setCarts(testCartList1);
        testProduct1.setGroup(testGroup1);

        List<CartEntity> testCartList2 = new ArrayList<>();
        testCartList2.add(new CartEntity());
        testProduct1.setCarts(testCartList2);
        testProduct2.setGroup(testGroup2);

        //When
        productDao.save(testProduct1);
        productDao.save(testProduct2);

        List<Product> readProductList = (List<Product>) productDao.findAll();

        //Then
        Assert.assertEquals(2, readProductList.size());
        Assert.assertTrue(productDao.findById(testProduct1.getId()).isPresent());
        Assert.assertTrue(productDao.findById(testProduct2.getId()).isPresent());

        Assert.assertEquals("Test Description with other Entities", readProductList.get(0).getDescription());
        Assert.assertEquals("Test no. 2 with other Entities", readProductList.get(1).getDescription());

        Assert.assertEquals("Spozywcze", readProductList.get(0).getGroup().getGroupName());
        Assert.assertEquals("AGD", readProductList.get(1).getGroup().getGroupName());

        //CleanUp
       try {
            productDao.deleteById(testProduct1.getId());
            productDao.deleteById(testProduct2.getId());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
