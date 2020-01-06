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
        //assertTrue(productDao.findAll().stream().anyMatch(oneProduct -> oneProduct.getId().equals(product1.getId())));

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
}
