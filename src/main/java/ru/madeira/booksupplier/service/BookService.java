package ru.madeira.booksupplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Service
public class BookService {

    private ProducerService producerService;

    @Autowired
    public void setProducerService(ProducerService producerService) {
        this.producerService = producerService;
    }

    private final static String fileAbsolutePath = "C:\\Users\\dmitr\\Desktop\\BookSupplier\\src\\main\\resources\\books.xml";

    public void updateBooksInLibrary() throws IOException {
        String fileString = Files.lines(Paths.get(fileAbsolutePath)).collect(Collectors.joining());
        producerService.sendMessage(fileString);
    }

}
