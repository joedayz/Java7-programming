package com.example;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Portfolio implements Serializable {

    private static final long serialVersionUID = 101L;
    private Set<Stock> stocks = new HashSet<>();

    public Portfolio () {
    }
    
    public Portfolio (Stock ...stocks) throws PortfolioException {
        for (Stock s: stocks) {
            addStock (s);
        }
    }

    private void addStock(Stock newStock) throws PortfolioException {
        try {
            if (!stocks.add(newStock)) {
                throw new PortfolioException("Stock " + newStock.getSymbol() + " is a duplicate.");
            }
        } catch (Exception e) {
            throw new PortfolioException("Exception from Set.add method: " + e);
        }
    }

    public double getValue() {
        double value = 0;
        for (Stock s : stocks) {
            value += s.getValue();
        }
        return value;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("Portfolio Summary\n");
        for (Stock s: stocks) {
            sb.append(s);
        }
        return sb.toString();
    }
}
