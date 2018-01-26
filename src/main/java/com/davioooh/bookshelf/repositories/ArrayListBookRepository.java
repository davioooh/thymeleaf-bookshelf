package com.davioooh.bookshelf.repositories;

import com.davioooh.bookshelf.domain.Book;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBookRepository implements BookRepository {

    private List<Book> db;

    public ArrayListBookRepository() {
        db = new ArrayList<>();
        // TODO init db
    }


    @Override
    public List<Book> findAll() {
        return ImmutableList.copyOf(db);
    }

    @Override
    public Book findOne(Integer id) {
        return db.stream()
                .filter(b -> b.getId() == id)
                .findFirst().orElse(null);
    }
}
