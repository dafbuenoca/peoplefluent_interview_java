/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peoplefluent.interview.java.fruitstand;

import static com.peoplefluent.interview.java.fruitstand.GroceryItem.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Defines a discount price for a set of GroceryItems.
 */
public class Discount {
    static Discount[] KnownDiscounts = {
        new Discount( BANANNA.price, BANANNA, BANANNA),
        new Discount( BANANNA.price, APPLE, BANANNA),
        new Discount( APPLE.price, APPLE, APPLE),
        new Discount( ORANGE.price*2, ORANGE, ORANGE, ORANGE),
    };
    public final int price;
    public final GroceryItem[] items;

    Discount(int price, GroceryItem ... items) {
        this.price = price;
        this.items = items;
    }

    /**
     * Returns a discounted price for the given discount.
     *
     * @param shoppingCart
     * @return 
     */
    public int applyDiscount(List<GroceryItem> shoppingCart) {
        int priceApplied = 0;

        // The discount list must have all items within the shopping cart with
        // the same quantities.  Below records the matchingIndices to avoid
        // eg, using the same Apple in the shopping cart when 2 are required.
        Set<Integer> matchedIndices = new HashSet<>();
        boolean validDiscount = true;
        for (GroceryItem gi : items) {
            boolean foundItem = false;
            int index = 0;
            for (GroceryItem shopItem : shoppingCart) {
                if (!matchedIndices.contains(index) &&
                    gi.equals(shopItem)) {
                    foundItem = true;
                    matchedIndices.add(index);
                    break;
                }
                index++;
            }
            validDiscount &= foundItem;

            if (!validDiscount) {
                break;
            }
        }

        // If they do, then this is a valid discount to apply.
        if (validDiscount) {
            // Remove items / "checkout".
            for (GroceryItem gi : items) {
                shoppingCart.remove(gi);
            }

            priceApplied = price;
        }

        return priceApplied;

    }

}
