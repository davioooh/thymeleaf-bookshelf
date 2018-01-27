package com.davioooh.bookshelf.repositories;

import com.davioooh.bookshelf.domain.Book;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

public class ArrayListBookRepository implements BookRepository {

    private List<Book> db;

    public ArrayListBookRepository() {
        db = Lists.newArrayList(
                Book.builder().id(1).title("Il vecchio e il mare").author("Ernest Hemingway").build(),
                Book.builder().id(2).title("Il signore degli anelli").author("J. R. R. Tolkien").build(),
                Book.builder().id(3).title("Il ritratto di Dorian Gray").author("Oscar Wilde").build()
        );

        // TODO init db
    }


    @Override
    public List<Book> findAll() {
        return ImmutableList.copyOf(db);
    }

    @Override
    public Book findOne(Integer id) {
        return db.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElse(null);
    }
}
