package com.davioooh.bookshelf.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
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
