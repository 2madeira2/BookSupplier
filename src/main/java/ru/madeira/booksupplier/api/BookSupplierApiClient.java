package ru.madeira.booksupplier.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("library")
public interface BookSupplierApiClient {
    @PostMapping("/books/updateBooksInLibrary")
    void sendXmlBooks(@RequestBody String xml);
}
