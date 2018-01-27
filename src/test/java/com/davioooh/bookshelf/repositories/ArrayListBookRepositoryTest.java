package com.davioooh.bookshelf.repositories;

import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayListBookRepositoryTest {

    @Test
    public void findAll() {
        val bookRepo = new ArrayListBookRepository();
        assertEquals(3, bookRepo.findAll().size());
    }

    @Test
    public void findOne() {
        val bookRepo = new ArrayListBookRepository();
        assertTrue(bookRepo.findOne(2).getTitle().equals("Il signore degli anelli"));
    }
}