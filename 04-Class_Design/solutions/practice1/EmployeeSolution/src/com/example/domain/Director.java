package com.example.domain;

public class Director extends Manager {

    private double budget;

    public Director(int empId, String name, String ssn, double salary, String department, double budget) {
        super(empId, name, ssn, salary, department);
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBudget:          " + getBudget();
    }
}