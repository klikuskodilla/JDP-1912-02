package com.kodilla.ecommercee.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    private String login;
    private Boolean isLoggedIn;
    private Integer sessionKey;
    private Date sessionKeyValidTo;
}

