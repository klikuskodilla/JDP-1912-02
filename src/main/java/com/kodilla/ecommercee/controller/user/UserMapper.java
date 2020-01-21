package com.kodilla.ecommercee.controller.user;

import com.kodilla.ecommercee.domain.user.UserBlockDto;
import com.kodilla.ecommercee.domain.user.UserEntity;
import com.kodilla.ecommercee.domain.user.UserEntityDto;
import com.kodilla.ecommercee.domain.user.UserLoginDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity mapToUserEntity(final UserEntityDto userEntityDto){
        return new UserEntity(
                userEntityDto.getName(),
                userEntityDto.getSurname(),
                userEntityDto.getLogin(),
                userEntityDto.getMail(),
                userEntityDto.getPassword()
        );
    }

    public UserEntityDto mapToUserEntityDto(final UserEntity userEntity){
        return new UserEntityDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getSurname(),
                userEntity.getLogin(),
                userEntity.getMail(),
                userEntity.getPassword()
        );
    }

    public UserLoginDto mapToUserLoginDto(final UserEntity userEntity){
        return new UserLoginDto(
                userEntity.getLogin(),
                userEntity.getIsLoggedIn(),
                userEntity.getSessionKey(),
                userEntity.getSessionKeyValidTo()
        );
    }

    public UserBlockDto mapToUserBlockDto(final UserEntity userEntity){
        return new UserBlockDto(
                userEntity.getLogin(),
                userEntity.getBlocked()
        );
    }
}
