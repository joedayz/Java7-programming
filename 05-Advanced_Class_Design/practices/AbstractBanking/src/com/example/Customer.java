package com.example;

public class Customer {

    private String firstName;
    private String lastName;
    private TimeDepositAccount[] accounts;
    private int numberOfAccounts;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        // initialize accounts array
        accounts = new TimeDepositAccount[10];
        numberOfAccounts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(TimeDepositAccount acct) {
        int i = numberOfAccounts++;
        accounts[i] = acct;
    }

    public int getNumOfAccounts() {
        return numberOfAccounts;
    }

    public TimeDepositAccount getAccount(int account_index) {
        return accounts[account_index];
    }
}