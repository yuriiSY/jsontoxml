package com.yuriisykal.utils;

import com.yuriisykal.modal.Book;
import com.yuriisykal.modal.statistic.Item;
import com.yuriisykal.modal.statistic.Statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsCalculator<T extends Book> {

    public Statistics calculateStatisticsByAttribute(List<T> items,String attribute) {
        Map<String, Integer> statMap = new HashMap<>();
        for (T item : items) {
            String s = getValueAttributeValue(item, attribute);
            statMap.put(s, statMap.getOrDefault(s,0) + 1);
        }

        List<Item> stat = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : statMap.entrySet()) {
            stat.add(new Item(entry.getKey(), entry.getValue()));
        }

        return new Statistics(stat);
    }



    private String getValueAttributeValue(T item, String attribute) {
        switch (attribute) {
            case "title" :
                return item.getTitle();
            case "author":
                return item.getAuthor();
            case "year_published":
                return String.valueOf(item.getYear_published());
            case "genre":
                return item.getGenre();
            default:
                throw new IllegalArgumentException();
        }
    }


}
