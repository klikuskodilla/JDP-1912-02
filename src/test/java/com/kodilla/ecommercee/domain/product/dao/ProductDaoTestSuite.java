package com.kodilla.ecommercee.domain.product.dao;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.dao.ProductDao;
import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.cart.dao.CartEntityDao;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.dao.GroupDao;
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
public class ProductDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private CartEntityDao cartEntityDao;

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
        CartEntity testCart1 = new CartEntity();
        CartEntity testCart2 = new CartEntity();

        testCart1.setCost(new BigDecimal(324.24));
        testCart2.setCost(new BigDecimal(56775.43));

        testProduct1.getCarts().add(testCart1);
        testProduct1.setGroup(testGroup1);

        testProduct2.getCarts().add(testCart2);
        testProduct2.setGroup(testGroup2);

        testCart1.getProducts().add(testProduct1);
        testCart2.getProducts().add(testProduct2);

        //When
        productDao.save(testProduct1);
        productDao.save(testProduct2);

        Optional<Product> readProduct1 = productDao.findById(testProduct1.getId());
        Optional<Product> readProduct2 = productDao.findById(testProduct2.getId());

        //Then
        Assert.assertTrue(readProduct1.isPresent());
        Assert.assertTrue(readProduct2.isPresent());

        Assert.assertEquals("Test Description with other Entities", readProduct1.get().getDescription());
        Assert.assertEquals("Test no. 2 with other Entities", readProduct2.get().getDescription());

        Assert.assertEquals("Spozywcze", readProduct1.get().getGroup().getGroupName());
        Assert.assertEquals("AGD", readProduct2.get().getGroup().getGroupName());

        Assert.assertEquals(BigDecimal.valueOf(324.24), readProduct1.get().getCarts().get(0).getCost());
        Assert.assertEquals(BigDecimal.valueOf(56775.43), readProduct2.get().getCarts().get(0).getCost());


        //CleanUp
       try {
            productDao.deleteById(testProduct1.getId());
            productDao.deleteById(testProduct2.getId());
            groupDao.deleteById(testGroup1.getGroup_id());
            groupDao.deleteById(testGroup2.getGroup_id());
            cartEntityDao.deleteById(testCart1.getId());
            cartEntityDao.deleteById(testCart2.getId());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
