package com.davioooh.bookshelf.controllers;

import com.davioooh.bookshelf.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String showAllBooks(Model model) {
        model.addAttribute("allBooks", bookService.getAll());
        return "book-list";
    }

    @GetMapping("/{id}")
    public String showBookDetails(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", bookService.getByID(id));
        return "book-details";
    }

}
