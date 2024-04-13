package com.yuriisykal.modal.statistic;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlElement(name = "value")
    private String value;
    @XmlElement(name = "count")
    private int count;

    public Item() {
    }

    public Item(String value, int count) {
        this.value = value;
        this.count = count;
    }

    // Геттеры и сеттеры
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}