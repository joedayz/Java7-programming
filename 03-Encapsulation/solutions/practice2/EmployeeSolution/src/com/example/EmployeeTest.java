package com.example;

import com.example.domain.Employee;
import com.example.domain.Engineer;
import com.example.domain.Manager;
import com.example.domain.Admin;
import com.example.domain.Director;
import java.text.NumberFormat;

public class EmployeeTest {

    public static void main(String[] args) {

        // Create the classes as per the practice
        Engineer eng1 = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27);
        Engineer eng2 = new Engineer(120, "Bill Lecomte", "045-89-1010", 110_450.34);
        
        Manager mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");

        Admin adm = new Admin(304, "Bill Munroe", "108-23-6509", 75_002.34);

        Director dir = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);

        // Print information about the objects you created
        printEmployee(eng1);
        printEmployee(eng2);
        printEmployee(adm);
        printEmployee(mgr);
        printEmployee(dir);

        System.out.println("\nTesting raiseSalary and setName on Manager:");
        mgr.setName ("Barbara Johnson-Smythe");
        mgr.raiseSalary(10_000.00);
        printEmployee(mgr);
        
        // Attempt to add three employees to the manager
        System.out.println(); // Print a blank line as a separator
        if (mgr.addEmployee(adm)) System.out.println ("Success: added admin");
        if (mgr.addEmployee(eng1)) System.out.println ("Success: added eng1");
        if (mgr.addEmployee(eng2)) System.out.println ("Success: added eng2");
        System.out.println(); // Print a blank line as a separator
        
        // Print out the staff
        mgr.printStaffDetails();
        System.out.println(); // Print a blank line as a separator
        
        // Attempt to remove a staff member
        if (mgr.removeEmployee(eng1)) System.out.println ("Success: removed eng1");
        System.out.println(); // Print a blank line as a separator
        
        // Print the staff again
        mgr.printStaffDetails();
    }

    public static void printEmployee(Employee emp) {
        System.out.println(); // Print a blank line as a separator
        // Print out the data in this Employee object
        System.out.println("Employee id:         " + emp.getEmpId());
        System.out.println("Employee name:       " + emp.getName());
        System.out.println("Employee Soc Sec #:  " + emp.getSsn());
        System.out.println("Employee salary:     " + NumberFormat.getCurrencyInstance().format((double) emp.getSalary()));
    }
}