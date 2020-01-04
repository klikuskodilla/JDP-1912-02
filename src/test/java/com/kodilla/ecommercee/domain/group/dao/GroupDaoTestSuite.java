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

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDaoTestSuite {

    @Autowired
    private GroupDao groupDao;

    @Test
    public void testSaveEntityRelactions (){

        Product prod1 = new Product("obraz olejny",new BigDecimal(2.22));
        Product prod2 = new Product("kolorowa plama", new BigDecimal(1.22));

        List<Product> listOf = new ArrayList<>();
        listOf.add(prod1);
        listOf.add(prod2);
        Group groupList = new Group(1L,"Sztuka",listOf);

        Product product3 = new Product("angry cat",new BigDecimal(3.33));
        Product product4 = new Product("blind dog", new BigDecimal(5.43));

        List<Product> nextList = new ArrayList<>();
        nextList.add(product3);
        nextList.add(product4);
        Group groupList_2= new Group(2L,"Pets",nextList);


        groupList_2.getGroupList().add(product3);
        groupList_2.getGroupList().add(product4);
        product3.setGroup(groupList_2);
        product4.setGroup(groupList_2);
        groupDao.save(groupList_2);
        Long id2 = groupList_2.getGroup_id();

        groupList.getGroupList().add(prod1);
        groupList.getGroupList().add(prod2);

        prod1.setGroup(groupList);
        prod2.setGroup(groupList);

        groupDao.save(groupList);
         Long id = groupList.getGroup_id();
         String s = groupList.getGroupName();

        Assert.assertNotEquals(java.util.Optional.of(0), id);
        Assert.assertEquals(s,groupList.getGroupName());

        //CleanUp
        groupDao.deleteById(id);
        groupDao.deleteById(id2);
        groupDao.delete(groupList);
        groupDao.delete(groupList_2);
    }
}
