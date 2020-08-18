package com.epam.patapau.service;

import com.epam.patapau.domain.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemServiceTest {

    private ItemService itemService;

    @Before
    public void setUp() throws Exception {
        itemService = new ItemService();
    }

    @After
    public void tearDown() throws Exception {
        itemService = null;
    }

    @Test
    public void getItems() {

        List<Item> expected = new ArrayList<>(
                Arrays.asList(
                        new Item("Book", 5.5),
                        new Item("Pen", 1.2),
                        new Item("Phone", 15),
                        new Item("Table", 123.75)
                ));

        List<Item> actual = ItemService.getItems();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSelectedItems() {
        List<String> expected = Arrays.asList("Book - 5,5 $", "Pen - 1,2 $");
        List<String> actual = itemService.getSelectedItems("Book - (5,5 $)", "Pen - (1,2 $)");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countSum() {
        double expected = 6.7;
        double actual = itemService.countSum("Book - (5,5 $)", "Pen - (1,2 $)");

        Assert.assertEquals(expected, actual, 0);
    }
}