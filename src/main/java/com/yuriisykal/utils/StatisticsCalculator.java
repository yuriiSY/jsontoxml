package com.yuriisykal.utils;

import com.yuriisykal.modal.Book;
import com.yuriisykal.modal.statistic.Item;
import com.yuriisykal.modal.statistic.Statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsCalculator<T extends Book> {
    /**
     * Calculates statistics based on the specified attribute for the given list of items.
     *
     * @param items     The list of items to calculate statistics for.
     * @param attribute The attribute to use for calculating statistics.
     * @return A Statistics object containing the calculated statistics.
     */
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


    /**
     * Retrieves the value of the specified attribute from the given item.
     *
     * @param item      The item from which to retrieve the attribute value.
     * @param attribute The attribute whose value to retrieve.
     * @return The value of the specified attribute for the given item.
     * @throws IllegalArgumentException if the specified attribute is not supported.
     */
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
