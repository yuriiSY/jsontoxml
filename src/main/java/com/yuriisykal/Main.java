package com.yuriisykal;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.yuriisykal.modal.Book;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
////        System.out.println("Hello world!");
////
////        ObjectMapper mapper = new ObjectMapper();
////
////        try {
////            List<Book> books = mapper.readValue(new File("src/main/resources/books.json"), new TypeReference<List<Book>>() {
////            });
////            System.out.println(books.toString());
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//
//        // Path to your folder containing JSON files
//        String folderPath = "src/main/resources/";
//
//        // Create ObjectMapper instances for JSON and XML
//        ObjectMapper jsonMapper = new ObjectMapper();
//        XmlMapper xmlMapper = new XmlMapper();
//
//        // Get all files in the folder
//        File folder = new File(folderPath);
//        File[] files = folder.listFiles();
//
//        // Process each file
//        if (files != null) {
//            for (File file : files) {
//                if (file.isFile() && file.getName().endsWith(".json")) {
//                    try {
//                        // Read JSON from file
//                        JsonNode jsonNode = jsonMapper.readTree(file);
//
//                        // Convert JSON to XML
//                        String xml = xmlMapper.writeValueAsString(jsonNode);
//
//                        // Output XML
//                        System.out.println("Converting " + file.getName() + " to XML:");
//                        System.out.println(xml);
//                    } catch (IOException e) {
//                        System.err.println("Error processing file: " + file.getName());
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } else {
//            System.err.println("Folder does not exist or is not a directory: " + folderPath);
//        }
//    }
//}
//
import com.yuriisykal.modal.Book;
import com.yuriisykal.modal.statistic.Statistics;
import com.yuriisykal.utils.JSONParser;
import com.yuriisykal.utils.StatisticsCalculator;
import com.yuriisykal.utils.XMLParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        List<Book> books = jsonParser.parseJsonFiles(args[0]);

        Statistics statistics = statisticsCalculator.calculateStatisticsByAttribute(books,args[1]);
        System.out.println(statistics);
        System.out.println(13);
        XMLParser xmlParser = new XMLParser();
        System.out.println(123);
       // xmlParser.parseToXml(statistics,args[1]);


//        // Створення мапи з даними
//        Map<String, Integer> dataMap = new HashMap<>();
//        dataMap.put("key1", 10);
//        dataMap.put("key2", 20);
//        dataMap.put("key3", 30);
//
//        // Створення об'єкту ObjectMapper для маршалінгу
//        ObjectMapper mapper = new XmlMapper();
//
//        try {
//            // Маршалінг мапи у файл XML
//            mapper.writeValue(new File("data.xml"), dataMap);
//            System.out.println("Мапа була успішно змаршалено у файл data.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
        // Path to your folder containing JSON files
//        String folderPath = args[0];
//
//        // Create ObjectMapper instances for JSON and XML
//        ObjectMapper jsonMapper = new ObjectMapper();
//        XmlMapper xmlMapper = new XmlMapper();
//
//        // Get all files in the folder
//        File folder = new File(folderPath);
//        File[] files = folder.listFiles();
//
//        // Process each file
//        if (files != null) {
//            for (File file : files) {
//                if (file.isFile() && file.getName().endsWith(".json")) {
//                    try {
//                        // Read JSON from file
//                        JsonNode jsonArray = jsonMapper.readTree(file);
//
//                        ObjectNode rootNode = jsonMapper.createObjectNode();
//                        rootNode.set("data", jsonArray);
//
//                        // Convert JSON object to XML
//                        String xml = xmlMapper.writeValueAsString(rootNode);
//
//                        // Output XML
//                        System.out.println("Converting " + file.getName() + " to XML:");
//                        System.out.println(xml);
//                    } catch (IOException e) {
//                        System.err.println("Error processing file: " + file.getName());
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } else {
//            System.err.println("Folder does not exist or is not a directory: " + folderPath);
//        }
//    }
}
