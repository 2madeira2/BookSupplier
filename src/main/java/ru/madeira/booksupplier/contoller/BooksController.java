package ru.madeira.booksupplier.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.madeira.booksupplier.service.BookService;

import java.io.IOException;

@RestController
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/updateBooksInLibrary")
    public void updateBooksInLibrary() throws IOException {
        this.bookService.updateBooksInLibrary();
    }

}
