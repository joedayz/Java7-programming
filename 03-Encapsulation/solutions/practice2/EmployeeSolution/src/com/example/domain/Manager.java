package com.example.domain;

public class Manager extends Employee {

    private String deptName;
    private Employee[] staff;
    private int employeeCount = 0;

    public Manager(int empId, String name, String ssn, double salary, String deptName) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
        // Construct an array of up to 20 employees
        this.staff = new Employee[20];
    }

    public String getDeptName() {
        return deptName;
    }

    // Add an employee to the list of employees this manager manages
    // Return true if the add was successful, return false if the employee exists already
    // Later you can use Exceptions instead
    public boolean addEmployee(Employee e) {
        if (findEmployee(e) != -1) return false;
        staff[employeeCount] = e;
        employeeCount++;
        return true;
    }
    
    // Find an employee in the array - return the index of the employee
    // in the array if they exist or -1 if they don't.
    public int findEmployee(Employee e) {
        int result = -1;
        for (int i = 0; i < employeeCount; i++)
            if (e.equals(staff[i])) result = i;
        return result;
    }

    // Remove an employee - this requires going through the array and removing
    // the one element that is this employee and at the same time resorting the array.
    // Return true if successful and false if Employee is not in the array.
    public boolean removeEmployee(Employee e) {
        boolean empPartOfStaff = false;
        Employee[] newStaff = new Employee[20];
        int newEmpCount = 0;
        for (int i = 0; i < employeeCount; i++) {
            if (staff[i].getEmpId() == e.getEmpId()) {
                empPartOfStaff = true;
            } else {
                newStaff[newEmpCount] = staff[i];
                newEmpCount++;
            }
        }
        // Was the employee found in the staff array?
        // If yes, use the updated staff array
        if (empPartOfStaff) {
            staff = newStaff;
            employeeCount = newEmpCount;
        }
        return empPartOfStaff;
    }
    
    // Print out the Staff
    public void printStaffDetails() {
        System.out.println ("Staff of " + this.getName() + ":");
        for (int i=0; i < employeeCount; i++) {
            System.out.println ("Name: " + staff[i].getName() + " Employee id: " + staff[i].getEmpId());
        }
    }
}