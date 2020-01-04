package com.kodilla.ecommercee.domain.user.dao;

import com.kodilla.ecommercee.domain.user.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite {
    @Autowired
    private UserEntityDao userDao;
    private static final String NAME = "John";
    private static final String SURNAME = "Rambo";
    private static final String LOGIN = "Test_Login";
    private static final String MAIL = "mail@test.com";
    private static final String PASSWORD = "testpassword";
    private static final Integer SESSION_KEY = 12345;

    @Test
    public void contextLoads(){}

    @Test
    public void testUserDaoSave(){
        //Given
        UserEntity user = new UserEntity(NAME, SURNAME, LOGIN, MAIL, PASSWORD);
        user.setSessionKey(SESSION_KEY);

        //When
        userDao.save(user);

        //Then
        Long id = user.getId();
        Optional<UserEntity> readUser = userDao.findById(id);
        Assert.assertTrue(readUser.isPresent());
        System.out.println(readUser.get().getId() + " | " + readUser.get().getName() + " |" + readUser.get().getSurname());


        //CleanUp
        //userDao.deleteById(id);
    }
}
