package com.example;

public class Bank {
    
    private static final Bank instance = new Bank();

    private Customer[] customers;
    private int numberOfCustomers;

    private Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }
    
    public static Bank getInstance() {
        return instance;
    }

    public void addCustomer(String f, String l) {
        int i = numberOfCustomers++;
        customers[i] = new Customer(f, l);
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int customer_index) {
        return customers[customer_index];
    }
}