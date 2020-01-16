package com.kodilla.ecommercee.controller.user;

import com.kodilla.ecommercee.domain.user.UserEntityDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserEntityDto userEntityDto){

    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntityDto blockUser(@RequestParam String login) throws UserNotFoundException{
        return new UserEntityDto(1L, "John", "Rambo", "JohnnyR",
                "theOne&OnlyJohnRambo@disaster.boom", "bullet", 12345, true );
    }

    @RequestMapping(method = RequestMethod.PUT, value = "generateSessionKey", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void generateSessionKey(@RequestParam String login,@RequestParam String password) throws UserNotFoundException{

    }
}
