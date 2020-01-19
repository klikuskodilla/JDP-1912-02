package com.kodilla.ecommercee.controller.user;

import com.kodilla.ecommercee.domain.user.UserEntity;
import com.kodilla.ecommercee.domain.user.dao.UserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class DBUserService {
    @Autowired
    private UserEntityDao createUserRepository;
    @Autowired
    private UserEntityDao blockUserRepository;
    @Autowired
    private UserEntityDao generateSessionUserRepository;

    public UserEntity saveUser(final UserEntity userEntity){
        return createUserRepository.save(userEntity);
    }

    public UserEntity blockUser(final String login) throws UserNotFoundException{
        UserEntity userToBlock = blockUserRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
        userToBlock.setBlocked(true);
        return blockUserRepository.save(userToBlock);
    }

    public UserEntity generateSession(final String login, final String password) throws UserAuthenticationFailedException, UserNotFoundException {
        UserEntity userToLogin = generateSessionUserRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
        if (userToLogin.getPassword().equals(password) && !userToLogin.getBlocked()){
            userToLogin.setSessionKey(new Random().nextInt(90000)+10000);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            userToLogin.setSessionKeyValidTo(calendar.getTime());
            userToLogin.setIsLoggedIn(true);
            return generateSessionUserRepository.save(userToLogin);
        } else {
            throw new UserAuthenticationFailedException();
        }
    }



}
