package com.yuriisykal.utils;


import com.yuriisykal.exeption.InvalidPathException;
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
    void parseJsonFiles_expectedCorrectSizeOfElements_Test() throws InvalidPathException {
       List<Book> books = jsonParser.parseJsonFiles("src/test/resources/files");
       Assertions.assertEquals(3,books.size());
    }

    @Test
    void incorrectParseJsonFiles_expectedInvalidPathException_Test()  {
        Assertions.assertThrows(InvalidPathException.class, () -> jsonParser.parseJsonFiles("src/main/resources123"));
    }

}
