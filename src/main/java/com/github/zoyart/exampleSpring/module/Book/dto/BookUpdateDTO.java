package com.github.zoyart.exampleSpring.module.Book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDTO {
    private String name;
    private String author;
    private int pageCount;
}
