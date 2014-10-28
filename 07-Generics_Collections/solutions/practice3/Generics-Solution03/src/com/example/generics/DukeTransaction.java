package com.example.generics;

public class DukeTransaction {

    private String productID = "";
    private String transactionType = "";
    private long count = 0;

    private DukeTransaction() {
    }

    private DukeTransaction(String productID, String transactionType, long count) {
        this.productID = productID;
        this.transactionType = transactionType;
        this.count = count;
    }

    public static DukeTransaction createTransaction(String productID, String transactionType, long count) {
        DukeTransaction newTransaction = new DukeTransaction(productID, transactionType,
                count);
        return newTransaction;
    }

    public String getProductID() {
        return this.productID;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public long getCount() {
        return this.count;
    }
}
