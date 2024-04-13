package com.yuriisykal.utils;


import com.yuriisykal.modal.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class JSONParserTest {

    JSONParser jsonParser;

    @BeforeEach
    void setUp() {
        jsonParser = new JSONParser();
    }

    @Test
    void parseJsonFiles() {
       List<Book> books = jsonParser.parseJsonFiles("src/main/resources");
       Assertions.assertEquals(3,books.size());
    }

}
//PLGQ35MXLBYQHUTVU48AXK78