package com.davioooh.bookshelf.repositories;

import com.davioooh.bookshelf.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findOne(Integer id);

}
