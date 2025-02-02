package com.devtiro.dbprep.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devtiro.dbprep.domain.Book;
import com.devtiro.dbprep.services.BookService;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/books")
    public ResponseEntity<Page<Book>> listBooks(final Pageable pageable) {
        return new ResponseEntity<Page<Book>>(bookService.getBooks(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<Book> listBooks(@PathVariable("isbn") final String isbn) {

        if ("mukc".equals(isbn)) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        else if ("muk".equals(isbn)) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }

        return bookService.getBook(isbn)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
}