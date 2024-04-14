package com.yuriisykal.utils;

import com.yuriisykal.modal.statistic.Item;
import com.yuriisykal.modal.statistic.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XMLParserTest {
    XMLParser xmlParser;
    List<Item> items;

    @BeforeEach
    void setUp() {
        xmlParser = new XMLParser(Statistics.class);
        items = Arrays.asList(
                new Item("Romeo and Juliet",2),
                new Item("1984",3)
        );
    }

    @Test
    void parseToXml() throws Exception {

        Path xmlFilePath = Path.of("statistics_by_title.xml");
        Files.deleteIfExists(xmlFilePath);

        Statistics statistics = new Statistics(items);
        xmlParser.parseToXml(statistics, "title");


        assertTrue(Files.exists(xmlFilePath));

        String xmlContent = Files.readString(xmlFilePath);

        assertTrue(xmlContent.contains("<value>Romeo and Juliet</value>"));
        assertTrue(xmlContent.contains("<count>2</count>"));
        assertTrue(xmlContent.contains("<value>1984</value>"));
        assertTrue(xmlContent.contains("<count>3</count>"));
    }
}