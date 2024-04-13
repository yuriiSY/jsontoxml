package com.yuriisykal.utils;


import com.yuriisykal.modal.statistic.Statistics;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


import java.io.File;


public class XMLParser{


    public void parseToXml(Statistics object, String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Statistics.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, new File("statistics_by_"+fileName+".xml"));;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
