package ru.madeira.booksupplier.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.madeira.booksupplier.api.BooksServiceApiClient;
import ru.madeira.booksupplier.model.Book;
import ru.madeira.booksupplier.util.xml.JaxbXmlConverter;
import ru.madeira.booksupplier.util.xml.wrapper.Books;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private final ProducerService producerService;
    private final BooksServiceApiClient booksServiceApiClient;
    private final JaxbXmlConverter jaxbXmlConverter;

    private final static String fileAbsolutePath = "C:\\Users\\dmitr\\Desktop\\BookSupplier\\src\\main\\resources\\books.xml";

    public void updateBooksInLibrary(Boolean fromInternet) throws IOException, JAXBException {
        String producerString;
        if (fromInternet) {
            List<Book> books = booksServiceApiClient.getBooks();
            System.out.println(books);
            Books booksWrapper = new Books();
            booksWrapper.setBooks(books);
            producerString = jaxbXmlConverter.convertToXmlString(booksWrapper, Books.class);
            System.out.println(producerString);
        } else {
            producerString = Files.lines(Paths.get(fileAbsolutePath)).collect(Collectors.joining());
        }
        producerService.sendMessage(producerString);
    }

}
