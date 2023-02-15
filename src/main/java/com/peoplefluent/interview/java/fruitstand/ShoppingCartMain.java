/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peoplefluent.interview.java.fruitstand;

import java.io.IOException;
import java.util.Arrays;

/**
 * Shopping Cart exercise
 *
 * @author Craig Taylor
 */
public class ShoppingCartMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ShoppingCart cart = new ShoppingCart(System.in, System.out);

        System.out.println("Enter series of following to checkout items:");

        System.out.println("Discounts:");
        for (Discount discount : Discount.KnownDiscounts) {
            System.out.format("  %8.02f - %s\n", discount.price / 100.0, Arrays.toString(discount.items));
        }

        System.out.println("\nIndividual Items:");
        for(GroceryItem item : GroceryItem.values()) {
            System.out.format("  %s - %-15.15s   %8.02f\n", item.match, item, item.price / 100.0);
        }

        System.out.println("  . - Done / Checkout and print total.");
        System.out.println("All other characters are ignored so, 'Apple Orange, Apple.' is valid.");
        System.out.println();

        cart.loadItems();

        System.out.println("Shopping Cart: ");
        cart.displayCart();

        int totalPrice = cart.getTotalPrice();
        System.out.format("Price : %.02f", totalPrice/100.0);
    }
}
