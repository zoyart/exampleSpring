package com.github.zoyart.exampleSpring.module.User.dto;

import com.github.zoyart.exampleSpring.module.Book.dto.BookShowDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserShowDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private List<BookShowDTO> books = new ArrayList<>();
}
