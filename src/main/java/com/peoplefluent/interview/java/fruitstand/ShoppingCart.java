/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peoplefluent.interview.java.fruitstand;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Shopping cart API allowing loading/display of items and calculation of prices.
 */
public class ShoppingCart {

    private List<String> items;

    /**
     * Constructor
     * @param inputScanner
     * @param outputStream
     */
    public ShoppingCart(Scanner inputScanner, PrintStream outputStream) {
        loadItems(inputScanner, outputStream);
    }

    /**
     * Load items into the shopping cart.
     */
    public void loadItems(Scanner inputScanner, PrintStream outputStream) {

        String input = "";
        do {
            outputStream.print("(. to checkout) : > ");
            input += inputScanner.nextLine();
        } while(!input.contains("."));

        // Convert input to list of single length strings that are GroceryItem
        // matches.A
        input = input.replaceAll("[^A-Z]", "");
        items = input.chars()
                .mapToObj( (int c) -> String.valueOf((char) c))
                .filter(val -> GroceryItem.matches().contains(val))
                .collect(Collectors.toList());
    }    

    /**
     * Print shopping cart items.
     */
    public void displayCart(PrintStream outputStream) {
        items.forEach((item) -> {
            outputStream.print(" " + GroceryItem.matchOf(item));
        });
        outputStream.println();
    }

    /**
     * Return total price of items in the cart.
     * @return
     */
    int getTotalPrice() {
        int totalPrice = 0;

        List<GroceryItem> groceryItems = items.stream()
                .map((current) -> GroceryItem.matchOf(current))
                .collect(Collectors.toList());

        // Keep applying the same discount until we're not able to. 
        for (Discount discount : Discount.KnownDiscounts) {
            int discountPrice;
            do {
                discountPrice = discount.applyDiscount(groceryItems);
                totalPrice += discountPrice;
            } while (discountPrice != 0);            
        }

        // Total up remaining individual items.        
        totalPrice = groceryItems.stream()
                .map(gi -> gi.price)
                .reduce(totalPrice, Integer::sum);

        return totalPrice;
    }
}
