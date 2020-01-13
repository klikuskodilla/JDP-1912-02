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
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDaoTestSuite {
    private Group group1;
    private Group group2;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @Autowired
    private GroupDao groupDao;
    @Autowired
    private ProductDao productDao;

    @Before
    public void sampleData(){
        product1 = new Product("RGB",new BigDecimal(2.22));
        product2 = new Product("MASCOT", new BigDecimal(1.22));
        product3 = new Product("RGB", new BigDecimal(3.22));
        product4 = new Product("MASCOT",new BigDecimal(0.43));

        group1 = new Group("Group Of Colors");
        group2 = new Group("Group Of Animals");
    }



    @Test
    public void testFindProductInGroup(){

        //Given
        product1.setGroup(group1);
        group1.getProducts().add(product1);
        product3.setGroup(group1);
        group1.getProducts().add(product3);

        groupDao.save(group1);

        product2.setGroup(group2);
        group2.getProducts().add(product2);
        product4.setGroup(group2);
        group2.getProducts().add(product4);

        groupDao.save(group2);

        //When
        Long groupId = group2.getGroup_id();
        Long productId = product2.getId();

        Optional<Group> findGroupById = groupDao.findById(groupId);
        String product3Description = product3.getDescription();

        //Then
        assertTrue(findGroupById.isPresent());
        assertEquals(4,productDao.count());
        assertEquals("Group Of Animals",findGroupById.get().getGroupName());
        assertEquals("RGB",product3Description);
        assertEquals("MASCOT",productDao.findById(productId).get().getDescription());
        assertEquals(findGroupById.get().getGroup_id(),product2.getGroup().getGroup_id());
        assertNotEquals(group1.getGroup_id(),product4.getGroup().getGroup_id());

        //Clean up
        groupDao.delete(group1);
        groupDao.delete(group2);
    }
}
