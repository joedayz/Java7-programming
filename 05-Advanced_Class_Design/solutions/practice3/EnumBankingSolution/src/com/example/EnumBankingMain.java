package com.example;

public class EnumBankingMain {

    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        
        if(bank == bank2) {
            System.out.println("bank and bank2 are the same object");
        }
        
        initializeCustomers(bank2);

        // run the customer report
        CustomerReport report = new CustomerReport();
        report.setBank(bank);
        report.generateReport();
    }

    private static void initializeCustomers(Bank bank) {
        Customer customer;
   
        // Create several customers and their accounts
        bank.addCustomer("Jane", "Simms");
        customer = bank.getCustomer(0);
        customer.addAccount(new TimeDepositAccount(500.00, DepositLength.SIX_MONTHS));
        customer.addAccount(new CheckingAccount(200.00, 400.00));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustomer(1);
        customer.addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustomer(2);
        customer.addAccount(new TimeDepositAccount(1500.00, DepositLength.SIX_MONTHS));
        customer.addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Maria", "Soley");
        customer = bank.getCustomer(3);
        // Maria and Tim have a shared checking account
        customer.addAccount(bank.getCustomer(2).getAccount(1));
        customer.addAccount(new TimeDepositAccount(150.00, DepositLength.THREE_MONTHS));
    }
}