package ru.madeira.booksupplier.util.xml.wrapper;

import lombok.Data;
import ru.madeira.booksupplier.model.Book;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Books {

    @XmlElement(name = "book")
    private List<Book> books;

}
