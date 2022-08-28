package ru.madeira.booksupplier.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Set;

@Data
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlElement
    private String title;

    @XmlElement
    private Integer year;

    @XmlElement
    private String description;

    @XmlElement(name = "author")
    @XmlElementWrapper(name = "authors")
    private Set<Author> authors;

    @XmlElement(name = "genre")
    @XmlElementWrapper(name = "genres")
    private Set<Genre> genres;
}
