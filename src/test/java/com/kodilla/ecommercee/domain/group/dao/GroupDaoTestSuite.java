package com.kodilla.ecommercee.domain.group.dao;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.dao.ProductDao;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.dao.GroupDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDaoTestSuite {
    private Group group1;
    private Group group2;
    private Product product1;
    private Product product2;

    @Autowired
    private GroupDao groupDao;
    @Autowired
    private ProductDao productDao;

    @Before
    public void sampleData(){
        product1 = new Product("RED",new BigDecimal(2.22));
        product2 = new Product("CAT", new BigDecimal(1.22));

        group1 = new Group("Group Of Colors");
        group2 = new Group("Group Of Animals");
    }


    @Test
    public void testCreateGroup(){

        product1.setGroup(group1);
        group1.getProductsGroup().add(product1);
        groupDao.save(group1);

        product2.setGroup(group2);
        group2.getProductsGroup().add(product2);
        groupDao.save(group2);

        Long groupId = group1.getGroupId();

        Optional<Group> isReal = groupDao.findById(groupId);
        assertTrue(isReal.isPresent());
        assertEquals("Group Of Colors",isReal.get().getGroupName());

        //CleanUp
        groupDao.deleteAll();
    }

    @Test
    public void findGroups(){
        product1.setGroup(group1);
        group1.getProductsGroup().add(product1);
        groupDao.save(group1);

        product2.setGroup(group2);
        group2.getProductsGroup().add(product2);
        groupDao.save(group2);

        List<Group> isFind = groupDao.findAll();

        assertEquals(2, isFind.size());

        //CleanUp
        groupDao.deleteAll();
    }
    @Test
    public void testFindProductInGroup(){
        product1.setGroup(group1);
        group1.getProductsGroup().add(product1);
        groupDao.save(group1);

        product2.setGroup(group2);
        group2.getProductsGroup().add(product2);
        groupDao.save(group2);

        Long groupId = group2.getGroupId();
        Long productId = product2.getId();

        Optional<Group> isReal = groupDao.findById(groupId);
        String isProduct = productDao.findById(productId).get().getDescription();

        assertTrue(isReal.isPresent());
        assertEquals("Group Of Animals",isReal.get().getGroupName());
        assertEquals(isProduct,productDao.findById(productId).get().getDescription());
    }
}
