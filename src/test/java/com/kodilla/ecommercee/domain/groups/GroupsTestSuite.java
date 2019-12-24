package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.groups.dao.GroupDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupsTestSuite {
    @Autowired
    private GroupDao groupDao;
    private static final String DESCRIPTION = "DUMMY TEST";


    @Test
    public void testGroupDaoSave() {
        //Given
        Group group = new Group(1L, DESCRIPTION);
        groupDao.save(group);
        Long Id = group.getGroupId();

        //When
        List<Group> readGroup = groupDao.findByGroupId(Id);

        //Then

        Assert.assertEquals(1,readGroup.size());

    }

}
