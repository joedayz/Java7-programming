package com.example.dao;

import com.example.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {

    // not thread-safe
    private static Employee[] employeeArray = new Employee[10];

    // package level access
    EmployeeDAOMemoryImpl() {
    }

    // Add an Employee record
    public void add(Employee emp) throws DAOException {
        if(employeeArray[emp.getId()] != null) {
            throw new DAOException("Error adding employee in DAO, employee id already exists " + emp.getId());
        }
        try {
            employeeArray[emp.getId()] = emp;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Error adding employee in DAO, id must be less than " + employeeArray.length);
        }
    }

    // Update an employee record
    public void update(Employee emp) throws DAOException {
        if(employeeArray[emp.getId()] == null) {
            throw new DAOException("Error updating employee in DAO, no such employee " + emp.getId());
        }
        try {
            employeeArray[emp.getId()] = emp;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Error updating employee in DAO, id must be less than " + employeeArray.length);
        }
    }

    // Delete an employee record that has this ID
    public void delete(int id) throws DAOException {
        if(employeeArray[id] == null) {
            throw new DAOException("Error deleting employee in DAO, no such employee " + id);
        }
        try {
            employeeArray[id] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Error deleting employee in DAO, id must be less than " + employeeArray.length);
        }
    }

    // Find an Employee record using this ID
    public Employee findById(int id) throws DAOException {
        try {
            return employeeArray[id];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Error finding employee in DAO", e);
        }
    }

    // Return an array of all of the Employee records
    // We are using a collection List object to store the results
    // This makes it easier to just add to the collection
    public Employee[] getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        // Iterate through the memory array and find Employee objects
        for (Employee e : employeeArray) {
            if (e != null) {
                emps.add(e);
            }
        }
        return emps.toArray(new Employee[0]);
    }

    @Override
    public void close() {
        System.out.println("No database connection to close just yet");
    }
}