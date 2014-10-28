package com.example.test;

import com.example.dao.DAOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.model.Employee;
import com.example.dao.EmployeeDAOFactory;
import com.example.dao.EmployeeDAO;
import java.text.DateFormat;
import java.util.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class EmployeeTestInteractive {

    private static ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle");
    
    public static void main(String[] args) {
        EmployeeDAOFactory factory = new EmployeeDAOFactory();

        boolean timeToQuit = false;
        try (EmployeeDAO dao = factory.createEmployeeDAO();
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                try {
                    timeToQuit = executeMenu(in, dao);
                } catch (DAOException e) {
                    System.out.println("Error " + e.getClass().getName());
                    System.out.println("Message: " + e.getMessage());
                }
            } while (!timeToQuit);
        } catch (IOException e) {
            System.out.println("Error " + e.getClass().getName() + " , quiting.");
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error closing resource " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static boolean executeMenu(BufferedReader in, EmployeeDAO dao) throws IOException, DAOException {
        Employee emp;
        String action;
        int id;

        System.out.println("Locale set to : " + Locale.getDefault());
        System.out.println("\n\n[C] - " + messages.getString("MainMenuCreate") 
                + " | [R] - " + messages.getString("MainMenuRead") + " | [U] - " + messages.getString("MainMenuUpdate")
                + " | [D] - " + messages.getString("MainMenuDelete") + " | [L] - " + messages.getString("MainMenuList")
                +" | [S] - " +  messages.getString("MainMenuSetLanguage") + " | [Q] - " + messages.getString("MainMenuQuit") + ": ");
        action = in.readLine();
        if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
            return true;
        }

        switch (action.toUpperCase().charAt(0)) {
            // Create a new employee record
            case 'C':
                emp = inputEmployee(in);
                dao.add(emp);
                System.out.println(messages.getString("CreateMenuSuccessMsg") + ": " + emp.getId());
                System.out.println("\n\n" + messages.getString("CreateMenuCreated") + " " + emp);
                break;

            // Display an employee record
            case 'R':
                System.out.println(messages.getString("ReadMenuEmployeeIdPrompt") + ": ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record
                emp = dao.findById(id);
                if (emp != null) {
                    System.out.println(emp + "\n");
                } else {
                    System.out.println("\n\n" + messages.getString("EmployeeId") + " " + id + " " + messages.getString("NotFound"));                    
                    break;
                }

                break;

            // Update an existing employee record    
            case 'U':
                System.out.println(messages.getString("UpdateMenuEmployeeIdPrompt") + ": ");
                id = new Integer(in.readLine().trim());
                // Find this Employee record
                emp = null;
                emp = dao.findById(id);
                if (emp == null) {
                    System.out.println("\n\n" + messages.getString("EmployeeId") + " " + id + " " + messages.getString("NotFound"));
                    break;
                }
                // Go through the record to allow changes

                emp = inputEmployee(in, emp);
                dao.update(emp);
                System.out.println(messages.getString("UpdateMenuSuccessMsg") + ": " + emp.getId());
                break;

            // Delete an employee record
            case 'D':
                System.out.println(messages.getString("DeleteMenuEmployeeIdPrompt") + ": ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record                 
                dao.delete(id);
                System.out.println(messages.getString("DeleteMenuDelete") + " " + id);
                break;

            // Display a list (Read the records) of Employees
            case 'L':
                Employee[] allEmps = dao.getAllEmployees();
                for (Employee employee : allEmps) {
                    System.out.println(employee + "\n");
                }
                break;
                
            // Set the default language
            case 'S':
                setLocale(in);
                break;
        }

        return false;
    }

    public static Employee inputEmployee(BufferedReader in) throws IOException {
        return inputEmployee(in, null, true);
    }

    public static Employee inputEmployee(BufferedReader in, Employee empDefaults) throws IOException {
        return inputEmployee(in, empDefaults, false);
    }

    public static Employee inputEmployee(BufferedReader in, Employee empDefaults, boolean newEmployee) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        int id = -1;
        String firstName;
        String lastName;
        Date birthDate = null;
        Employee emp;
        float salary;

        if (newEmployee) {
            do {
                System.out.println(messages.getString("InputMenuEmployeeIdPrompt") + ": ");
                try {
                    id = new Integer(in.readLine().trim());
                    if (id < 0) {
                        System.out.println(messages.getString("InputMenuEmployeeNegativeError"));
                    }
                } catch (NumberFormatException e) {
                    System.out.println(messages.getString("InputMenuEmployeeNegativeError"));
                }
            } while (id < 0);
        } else {
            id = empDefaults.getId();
            System.out.println(messages.getString("InputMenuUpdateEmployeeIdPrompt1") + ": " + id
                    + ". " + messages.getString("InputMenuUpdateEmployeeIdPrompt2") + ".");
        }

        String prompt = messages.getString("InputMenuFirstNamePrompt") + ((empDefaults == null) ? "" : " [" + empDefaults.getFirstName() + "]");

        do {
            System.out.println(prompt + " : ");
            firstName = in.readLine().trim();
            if (firstName.equals("") && empDefaults != null) {
                firstName = empDefaults.getFirstName();
            }
            if (firstName.length() < 1) {
                System.out.println(messages.getString("InputMenuFirstNameError"));
            }
        } while (firstName.length() < 1);


        prompt =  messages.getString("InputMenuLastNamePrompt") + ((empDefaults == null) ? "" : " [" + empDefaults.getLastName() + "]");
        do {
            System.out.println(prompt + " : ");
            lastName = in.readLine().trim();
            if (lastName.equals("") && empDefaults != null) {
                lastName = empDefaults.getLastName();
            }
            if (lastName.length() < 1) {
                System.out.println(messages.getString("InputMenuLastNameError"));
            }
        } while (lastName.length() < 1);


        prompt = messages.getString("InputMenuBirthDatePrompt") + " (" + df.toLocalizedPattern() + ")"
                + ((empDefaults == null) ? "" : " [" + df.format(empDefaults.getBirthDate()) + "]");
        do {
            System.out.println(prompt + " : ");
            String dateStr = in.readLine().trim();
            if (dateStr.equals("") && empDefaults != null) {
                birthDate = empDefaults.getBirthDate();
            } else {
                birthDate = null;
                try {
                    birthDate = new Date(df.parse(dateStr).getTime());
                } catch (ParseException e) {
                    System.out.println(messages.getString("InputMenuBirthDateError") + ": " + e.getMessage());
                }
            }
        } while (birthDate == null);


        prompt = messages.getString("InputMenuSalaryPrompt")
                + ((empDefaults == null) ? "" : " [" + nf.format((double) empDefaults.getSalary()) + "]");
        do {
            System.out.println(prompt + " : ");
            salary = 0;
            try {
                String amt = in.readLine().trim();
                if (!amt.equals("")) {
                    salary = Float.parseFloat(amt);
                }
                if (salary == 0 && empDefaults != null) {
                    salary = empDefaults.getSalary();
                }
                if (salary < 0) {
                    System.out.println(messages.getString("InputMenuSalaryNegativeError"));
                    salary = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println(messages.getString("InputMenuSalaryFloatError") + ": " + e.getMessage());
            }
        } while (salary == 0);

        // Create an Employee object
        emp = new Employee(id, firstName, lastName, birthDate, salary);
        return emp;
    }
    
    public static void setLocale(BufferedReader in){
        String action = "";
        
        System.out.println(messages.getString("SetLanguageMenu1"));
        System.out.println(messages.getString("SetLanguageMenu2"));
        System.out.println(messages.getString("SetLanguageMenu3"));
        System.out.println(messages.getString("SetLanguageMenu4"));
        
        try {
            action = in.readLine().trim();
        }  catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        switch (action){ // US English
            case "1":
                Locale.setDefault(Locale.US);
                messages = ResourceBundle.getBundle("MessagesBundle", Locale.US);
                break;
                
            case "2": // French
                Locale.setDefault(Locale.FRANCE);
                messages = ResourceBundle.getBundle("MessagesBundle", Locale.FRANCE);
                break;
                
            case "3": // Russian
                Locale russiaLocale = new Locale("ru", "RU");
                Locale.setDefault(russiaLocale);
                messages = ResourceBundle.getBundle("MessagesBundle", russiaLocale);
                break;
        }
    }
}