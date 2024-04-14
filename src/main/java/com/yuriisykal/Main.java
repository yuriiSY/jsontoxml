package com.yuriisykal;

import com.yuriisykal.exeption.InvalidPathException;
import com.yuriisykal.modal.Book;
import com.yuriisykal.modal.statistic.Statistics;
import com.yuriisykal.utils.JSONParser;
import com.yuriisykal.utils.StatisticsCalculator;
import com.yuriisykal.utils.XMLParser;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InvalidPathException {
        JSONParser jsonParser = new JSONParser();
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        List<Book> books = jsonParser.parseJsonFiles(args[0]);
        Statistics statistics = statisticsCalculator.calculateStatisticsByAttribute(books, args[1]);
        XMLParser xmlParser = new XMLParser(Statistics.class);
        xmlParser.parseToXml(statistics,args[1]);
    }
}
