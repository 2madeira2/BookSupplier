package ru.madeira.booksupplier.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.madeira.booksupplier.service.BookService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/updateBooksInLibrary")
    public void updateBooksInLibrary(@RequestParam (defaultValue = "false") Boolean fromInternet) throws IOException, JAXBException {
        this.bookService.updateBooksInLibrary(fromInternet);
    }
}
