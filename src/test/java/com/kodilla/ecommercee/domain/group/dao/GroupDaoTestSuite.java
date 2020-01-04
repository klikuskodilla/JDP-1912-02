package com.kodilla.ecommercee.domain.group.dao;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.dao.ProductDao;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.dao.GroupDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private GroupDao groupDao;

    @Test
    public void testSaveEntityRelactions (){

        Product prod1 = new Product("obraz olejny",new BigDecimal(2.22));
        Product prod2 = new Product("budynek mieszkalny", new BigDecimal(1.22));
        //Given


        Group groupList = new Group(1L,"Grupa Pierwsza");

        groupList.getGroupList().add(prod1);
        groupList.getGroupList().add(prod2);

        prod1.setGroup(groupList);
        prod2.setGroup(groupList);

        //When
        groupDao.save(groupList);
        int id = groupList.getId();

        //Then
        Assert.assertNotEquals(0, id);
    }
}
