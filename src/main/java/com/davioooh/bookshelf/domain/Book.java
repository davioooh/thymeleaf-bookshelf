package com.davioooh.bookshelf.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    private String description;
    private Date publicationDate;

}
