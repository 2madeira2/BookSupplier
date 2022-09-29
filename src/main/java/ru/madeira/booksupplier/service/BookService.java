package ru.madeira.booksupplier.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.madeira.booksupplier.api.BookSupplierApiClient;
import ru.madeira.booksupplier.api.BooksConsumerApiClient;
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
@RequiredArgsConstructor
public class BookService {

    private final ProducerService producerService;
    private final BooksConsumerApiClient booksConsumerApiClient;
    private final BookSupplierApiClient bookSupplierApiClient;
    private final JaxbXmlConverter jaxbXmlConverter;

    @Value("${book.forgetting.file-path}")
    private String fileAbsolutePath;

    public void updateBooksInLibrary(Boolean fromInternet, Boolean withKafka) throws IOException, JAXBException {
        String producerString;
        if (fromInternet) {
            List<Book> books = booksConsumerApiClient.getBooks();
            System.out.println(books);
            Books booksWrapper = new Books();
            booksWrapper.setBooks(books);
            producerString = jaxbXmlConverter.convertToXmlString(booksWrapper, Books.class);
            System.out.println(producerString);
        } else {
            producerString = Files.lines(Paths.get(fileAbsolutePath)).collect(Collectors.joining());
        }
        if (withKafka) {
            producerService.sendMessage(producerString);
        } else {
            bookSupplierApiClient.sendXmlBooks(producerString);
        }
    }

}
