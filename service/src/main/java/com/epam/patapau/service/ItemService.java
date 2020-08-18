package com.epam.patapau.service;

import com.epam.patapau.domain.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemService {

    private static final List<Item> ITEMS = new ArrayList<>(
            Arrays.asList(
                    new Item("Book", 5.5),
                    new Item("Pen", 1.2),
                    new Item("Phone", 15),
                    new Item("Table", 123.75)
            )
    );

    public static List<Item> getItems() {
        return ITEMS;
    }

    public List<String> getSelectedItems(String... items) {
        List<String> result = new ArrayList<>();
        for (String item : items) {
            result.add(item.replaceAll("\\(", "").replaceAll("\\)", ""));
        }
        return result;
    }

    public double countSum(String... items) {
        double result = 0;
        for (String item : items) {
            item = item.replaceAll("[^\\d,]", "").replaceAll(",", ".");
            result += Double.parseDouble(item);
        }
        return result;
    }
}
