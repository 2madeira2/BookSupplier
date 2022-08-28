package ru.madeira.booksupplier.util.xml;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Component
public class JaxbXmlConverter {
    public <T> String convertToXmlString(T object, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller mar = context.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(object, stringWriter);
        return stringWriter.toString();
    }
}
