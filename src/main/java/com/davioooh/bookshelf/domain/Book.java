package com.davioooh.bookshelf.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String description;

}
