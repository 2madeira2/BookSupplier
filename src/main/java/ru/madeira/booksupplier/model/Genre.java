package ru.madeira.booksupplier.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "genre")
@XmlAccessorType(XmlAccessType.FIELD)
public class Genre {
    @XmlElement
    private String name;
}
