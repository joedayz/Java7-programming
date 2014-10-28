package com.example.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestItemCounter {

    public static void main(String[] args) {
        // Current Shirt type for a transaction
        Shirt currentShirt = null;

        // Create Items to Count
        Map<String, Shirt> polos = new HashMap<>(10);
        polos.put("P001", new Shirt("P001", "Blue Polo Shirt", "Blue", "L"));
        polos.put("P002", new Shirt("P002", "Black Polo Shirt", "Black", "M"));
        polos.put("P003", new Shirt("P003", "Maroon Polo Shirt", "Maroon", "XL"));
        polos.put("P004", new Shirt("P004", "Tan Polo Shirt", "Tan", "S"));

        // Transactions
        List<DukeTransaction> transactions = new ArrayList<>(20);
        transactions.add(DukeTransaction.createTransaction("P001", "Purchase", 30));
        transactions.add(DukeTransaction.createTransaction("P002", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P003", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P004", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 1));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 5));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 1));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 3));
        transactions.add(DukeTransaction.createTransaction("P003", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P003", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P003", "Sale", 3));
        transactions.add(DukeTransaction.createTransaction("P004", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P004", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P004", "Sale", 4));

        // Count the shirts
        for (DukeTransaction transaction : transactions) {
            if (polos.containsKey(transaction.getProductID())) {
                currentShirt = polos.get(transaction.getProductID());
            } else {
                System.out.println("Error: Invalid part number");
            }

            switch (transaction.getTransactionType()) {
                case "Purchase":
                    currentShirt.addItems(transaction.getCount());
                    break;

                case "Sale":
                    currentShirt.removeItems(transaction.getCount());
                    break;

                default:
                    System.out.println("Error: Invalid Transaction Type");
                    continue;
            }

        }

        // Convert to List
        List<Shirt> poloList = new ArrayList<>(polos.values());

        // Init Comparators
        Comparator<Shirt> sortDescription = new SortShirtByDesc();
        Comparator<Shirt> sortCount = new SortShirtByCount();

        // Print Results - Sort by Description
        Collections.sort(poloList, sortDescription);
        System.out.println("=== Inventory Report - Description ===");

        for (Shirt shirt : poloList) {
            System.out.println(shirt.toString());
        }

        // Print Results - Sort by Count
        Collections.sort(poloList, sortCount);
        System.out.println("=== Inventory Report - Count ===");

        for (Shirt shirt : poloList) {
            System.out.println(shirt.toString());
        }
    }
}
