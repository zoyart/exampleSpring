package com.github.zoyart.exampleSpring.module.User.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    private String firstname;
    private String lastname;
    private String email;
}
