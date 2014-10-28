package com.example.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private float salary;
    private ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle");

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, Date birthDate, float salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return messages.getString("EmployeeId") + ":   " + getId() + "\n"
                + messages.getString("EmployeeName") + ": " + getFirstName() + " " + getLastName() + "\n"
                + messages.getString("EmployeeBirthDate") + ":    " + new SimpleDateFormat("MMM d, yyyy").format(getBirthDate()) + "\n"
                + messages.getString("EmployeeSalary") + ":        " + NumberFormat.getCurrencyInstance().format((double) getSalary());
    }
}