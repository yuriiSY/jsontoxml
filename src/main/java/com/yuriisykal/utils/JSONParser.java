package com.yuriisykal.utils;

import com.fasterxml.jackson.core.JsonFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.yuriisykal.modal.Book;
import com.yuriisykal.modal.SimpleBook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JSONParser {

    public List<Book> parseJsonFiles(String folderPath) {
        List<Book> books = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".json")) {
                    executor.submit(() -> books.addAll(parseJsonFile(file)));
                }
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return books;
    }

    private List<Book> parseJsonFile(File file) {
        List<Book> books = new ArrayList<>();

        JsonFactory jsonFactory = new JsonFactory();

        try (JsonParser jsonParser = jsonFactory.createParser(file)){
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                Book book = new SimpleBook();
                while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = jsonParser.getCurrentName();
                    if (fieldName == null) {
                        continue;
                    }
                    switch (fieldName) {
                        case "title":
                            jsonParser.nextToken();
                            book.setTitle(jsonParser.getValueAsString());
                            break;
                        case "author":
                            jsonParser.nextToken();
                            book.setAuthor(jsonParser.getValueAsString());
                            break;
                        case "year_published":
                            jsonParser.nextToken();
                            book.setYear_published(jsonParser.getValueAsInt());
                            break;
                        case "genre":
                            jsonParser.nextToken();
                            book.setGenre(jsonParser.getValueAsString());
                            break;
                        default:
                            break;
                    }
                }
                books.add(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }



}
