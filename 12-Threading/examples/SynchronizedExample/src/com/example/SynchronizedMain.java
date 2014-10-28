package com.example;

public class SynchronizedMain {

    public static void main(String[] args) {
        // Create a ShoppingCart
        ShoppingCart cart = new ShoppingCart();
        // Add some items
        cart.addItem(new Item(101, "Boomerang", 10.95));
        cart.addItem(new Item(123, "Soccer Ball", 29.95));
        cart.addItem(new Item(45, "Tennis Ball 4 Pack", 17.49));

        // Print some messages about the cart
        cart.printCart();
    }
}
