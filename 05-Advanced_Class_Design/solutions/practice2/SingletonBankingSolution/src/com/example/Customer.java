package com.example;

public class Customer {

    private String firstName;
    private String lastName;
    private Account[] accounts;
    private int numberOfAccounts;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        // initialize accounts array
        accounts = new Account[10];
        numberOfAccounts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(Account acct) {
        int i = numberOfAccounts++;
        accounts[i] = acct;
    }

    public int getNumOfAccounts() {
        return numberOfAccounts;
    }

    public Account getAccount(int account_index) {
        return accounts[account_index];
    }
}