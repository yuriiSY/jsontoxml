package com.yuriisykal.utils;

import com.yuriisykal.modal.Book;
import com.yuriisykal.modal.SimpleBook;
import com.yuriisykal.modal.statistic.Item;
import com.yuriisykal.modal.statistic.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class StatisticsCalculatorTest {
    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("genre", Arrays.asList(new Item("Romance",2)) ),
                Arguments.of("author", Arrays.asList(new Item("Jane Austen",1), new Item("William Shakespeare",1))),
                Arguments.of("title", Arrays.asList(new Item("Pride and Prejudice",1), new Item("Romeo and Juliet",1))),
                Arguments.of("year_published", Arrays.asList(new Item("1597",1),new Item("1813",1)))
        );
    }
    StatisticsCalculator statisticsCalculator;
    List<Book> books;
    @BeforeEach
    void setUp() {
        statisticsCalculator = new StatisticsCalculator();
        books = Arrays.asList(
                new SimpleBook("Romeo and Juliet","William Shakespeare",1597,"Romance"),
                new SimpleBook("Pride and Prejudice","Jane Austen",1813,"Romance")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void calculateStatisticsByAttribute(String attribute, List<Item> items) {
        Statistics expected = new Statistics(items);
        Statistics actual = statisticsCalculator.calculateStatisticsByAttribute(books,attribute);
        Assertions.assertEquals(expected,actual);
    }
}