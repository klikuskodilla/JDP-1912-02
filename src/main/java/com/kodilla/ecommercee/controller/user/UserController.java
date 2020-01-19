package com.kodilla.ecommercee.controller.user;

import com.kodilla.ecommercee.controller.product.DBProductService;
import com.kodilla.ecommercee.domain.user.UserBlockDto;
import com.kodilla.ecommercee.domain.user.UserEntityDto;
import com.kodilla.ecommercee.domain.user.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DBUserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntityDto createUser(@RequestBody UserEntityDto userEntityDto){
        return userMapper.mapToUserEntityDto(userService.saveUser(userMapper.mapToUserEntity(userEntityDto)));

    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserBlockDto blockUser(@RequestParam String login) throws UserNotFoundException{
        return userMapper.mapToUserBlockDto(userService.blockUser(login));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "generateSessionKey", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserLoginDto generateSessionKey(@RequestParam String login, @RequestParam String password) throws UserAuthenticationFailedException, UserNotFoundException{
        return userMapper.mapToUserLoginDto(userService.generateSession(login, password));
    }
}
