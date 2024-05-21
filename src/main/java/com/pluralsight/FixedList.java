package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class FixedList<T> {
    private List<T> items;
    private int maxSize;

    public FixedList(int maxSize) {
        this.items = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }
    public void add(T item) {
        if (items.size() < maxSize) {
            items.add(item);
        } else {
            System.out.println("Cannot add more items. Maximum size reached.");
        }
    }

    public List<T> getItems() {
        return new ArrayList<>(this.items);
    }

    public static void main(String[] args) {
        FixedList<Integer> numbers = new FixedList<>(3); // Creating a FixedList of Strings with max size 3
        numbers.add(10);
        numbers.add(3);
        numbers.add(92);
        numbers.add(43); // this number should Fail
        System.out.println(numbers.getItems().size());

        FixedList<LocalDate> dates = new FixedList<>(3);
        dates.add(LocalDate.now());
        dates.add(LocalDate.now());
        //dates.add(LocalDate.ofEpochDay(15)); // this line should fail


        List<LocalDate> dateItems = dates.getItems();
        System.out.println("Items in the list:");
        for (LocalDate item : dateItems) {
            System.out.println(item);
        }
    }
}
