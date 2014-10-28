package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Random;

public class Stock implements Serializable {

    private static final long serialVersionUID = 100L;
    private String symbol;
    private int shares;
    private double purchasePrice;
    private transient double currPrice;

    public Stock(String symbol, int shares, double purchasePrice) {
        this.symbol = symbol;
        this.shares = shares;
        this.purchasePrice = purchasePrice;
        setStockPrice();
    }

    // This method is called post-serialization
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // perform other initiliazation
        setStockPrice();
    }

    public String getSymbol() {
        return symbol;
    }

    public double getValue() {
        return shares * currPrice;
    }

    // Normally the current stock price would be fetched via a feed
    // Here we will simulate that
    private void setStockPrice() {
        Random r = new Random();
        double rVal = r.nextDouble();
        double p = 0;
        if (currPrice == 0) {
            p = purchasePrice;
        } else {
            p = currPrice;
        }
        // calculate the new price
        if (rVal < 0.5) {
            currPrice = p + (-10 * rVal);
        } else {
            currPrice = p + (10 * rVal);
        }
    }

    @Override
    public String toString() {
        double value = getValue();
        return "Stock:  " + symbol + "\n"
                + "Shares: " + shares + " @ " + NumberFormat.getCurrencyInstance().format(purchasePrice) + "\n"
                + "Curr $: " + NumberFormat.getCurrencyInstance().format(currPrice) + "\n"
                + "Value:  " + NumberFormat.getCurrencyInstance().format(value) + "\n";
    }
}
