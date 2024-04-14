package com.yuriisykal.utils;

import com.fasterxml.jackson.core.JsonFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.yuriisykal.exeption.InvalidPathException;
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

    /**
     * Parses JSON files within the specified folder path and returns a list of books.
     *
     * @param folderPath The path to the directory containing JSON files.
     * @return A list of books parsed from the JSON files.
     * @throws InvalidPathException If the folder does not exist or is not a directory.
     */

    public List<Book> parseJsonFiles(String folderPath) throws InvalidPathException {
        List<Book> books = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        File folder = new File(folderPath);
        if (!folder.exists() ) {
            throw new InvalidPathException("Folder does not exist");
        }
        if (!folder.isDirectory()) {
            throw new InvalidPathException("Folder is not directory");
        }


        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".json")) {
                    executor.submit(() -> books.addAll(parseJsonFile(file)));
                    System.out.println(file.getName() +" file has been parsed");
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
    /**
     * Parses a JSON file containing book information and returns a list of books.
     *
     * @param file The JSON file to parse.
     * @return A list of books parsed from the JSON file.
     */
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
