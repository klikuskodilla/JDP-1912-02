package com.kodilla.ecommercee.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserBlockDto {
    private String login;
    private Boolean isBlocked;
}
