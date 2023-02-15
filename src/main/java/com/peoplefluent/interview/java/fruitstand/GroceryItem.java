/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peoplefluent.interview.java.fruitstand;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic Grocery Item defining it's match input string, price and a renderable
 * name. 
 */
public enum GroceryItem {
    APPLE("A", 60, "Apple"),
    ORANGE("O", 25, "Orange"),
    BANANNA("B", 20, "Bananna");

    static List<String> matches() {
        return Arrays.asList(GroceryItem.values()).stream()
                .map(it -> it.match)
                .collect(Collectors.toList());
    }

    public final String match;
    public final int price;
    private final String itemName;

    GroceryItem(String match, int price, String itemName) {
        this.match = match;
        this.price = price;
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }

    public static GroceryItem matchOf(String match) {
        return Arrays.asList(values()).stream()
                .filter(it -> it.match.equals(match))
                .findFirst().orElse(null);
    }
}
