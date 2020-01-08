package com.kodilla.ecommercee.controller.user;

import com.kodilla.ecommercee.domain.user.UserEntityDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(UserEntityDto userEntityDto){

    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public UserEntityDto blockUser(String login){
        return new UserEntityDto(1L, "John", "Rambo", "JohnnyR",
                "theOne&OnlyJohnRambo@disaster.boom", "bullet", 12345, true );
    }

    @RequestMapping(method = RequestMethod.PUT, value = "generateSessionKey")
    public void generateSessionKey(String login, String password){

    }
}
