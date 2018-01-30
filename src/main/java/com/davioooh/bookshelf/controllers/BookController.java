package com.davioooh.bookshelf.controllers;

import com.davioooh.bookshelf.domain.Book;
import com.davioooh.bookshelf.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        model.addAttribute("book", bookService.getById(id));
        return "book-details";
    }

    @GetMapping("/{id}/edit")
    public String showBookEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "book-edit";
    }

    @GetMapping("/new")
    public String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-edit";
    }

    @PostMapping("/save")
    public String submitBookEdit(
            @Valid @ModelAttribute Book book
            , BindingResult bindingResult
            , RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return "book-edit";
        }

        book = bookService.save(book);

        return "redirect:/books/" + book.getId();
    }
}
