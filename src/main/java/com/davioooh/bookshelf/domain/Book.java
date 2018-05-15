package com.davioooh.bookshelf.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    private String description;
    private Integer publicationYear;
    private Type type;

    public enum Type {
        NOVEL,
        ESSAY,
        MANUAL
    }
}
