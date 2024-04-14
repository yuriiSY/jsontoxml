package com.yuriisykal.utils;


import com.yuriisykal.modal.statistic.Statistics;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


import java.io.File;


public class XMLParser<T> {

    private JAXBContext context;

    public XMLParser(Class<T> instance) {
        try {
            this.context = JAXBContext.newInstance(instance);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parses the given object into an XML file with the specified file name.
     *
     * @param object   The Statistics object to parse into XML.
     * @param fileName The name of the XML file to create.
     * @throws RuntimeException if an error occurs during JAXB marshalling.
     */
    public void parseToXml(Statistics object, String fileName) {
        try {

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            String file = "statistics_by_"+fileName+".xml";
            marshaller.marshal(object, new File(file));
            System.out.println(file + " has been created");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
