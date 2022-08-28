package ru.madeira.booksupplier.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.madeira.booksupplier.model.Book;

import java.util.List;

@FeignClient(value = "booksData", url = "https://jsonkeeper.com/b/AJGT")
public interface BooksServiceApiClient {
    @GetMapping
    List<Book> getBooks();
}
