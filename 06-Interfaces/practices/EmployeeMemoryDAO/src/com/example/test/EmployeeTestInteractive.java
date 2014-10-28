package com.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.model.Empleado;
import com.example.model.EmpleadoDAO;
import com.example.model.EmpleadoDAOFactory;
import com.example.model.EmpleadoDAOMemoryImpl;
import java.util.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeTestInteractive {

    public static void main(String[] args) throws Exception {
        EmpleadoDAOFactory factory = new EmpleadoDAOFactory();

        boolean timeToQuit = false;

        
        EmpleadoDAO dao =  factory.crearEmpleadoDAO();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            timeToQuit = executeMenu(in, dao);
        } while (!timeToQuit);
    }

    public static boolean executeMenu(BufferedReader in, EmpleadoDAO dao) throws IOException {
        Empleado emp;
        String action;
        int id;

        System.out.println("\n\n[C]reate | [R]ead | [U]pdate | [D]elete | [L]ist | [Q]uit: ");
        action = in.readLine();
        if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
            return true;
        }

        switch (action.toUpperCase().charAt(0)) {
            // Create a new employee record
            case 'C':
                emp = inputEmployee(in);
                dao.add(emp);
                System.out.println("Empleado : " + emp.getId() + " registrado satisfactoriamente");
                System.out.println("\n\nCreado " + emp);
                break;

            // Display an employee record
            case 'R':
                System.out.println("Ingrese un valor entero para employee id: ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record
                emp = dao.findById(id);
                if (emp != null) {
                    System.out.println(emp + "\n");
                } else {
                    System.out.println("\n\nEmpleado " + id + " no encontrado");
                    break;
                }

                break;

            // Update an existing employee record    
            case 'U':
                System.out.println("Ingrese un valor entero para employee id: ");
                id = new Integer(in.readLine().trim());
                // Find this Employee record
                emp = null;
                emp = dao.findById(id);
                if (emp == null) {
                    System.out.println("\n\nEmpleado " + id + " no encontrado");
                    break;
                }
                // Go through the record to allow changes

                emp = inputEmployee(in, emp);
                dao.update(emp);
                System.out.println("Empleado: " + emp.getId() + " modificado satisfactoriamente");
                break;

            // Delete an employee record
            case 'D':
                System.out.println("Ingrese un valor entero para employee id: ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record                 
                //emp = null;
                //emp = Empleado.findById(id);
                dao.delete(id);
                //if (emp == null) {
                //    System.out.println("\n\nEmpleado " + id + " no encontrado");
                //    break;
                //}
                //emp.delete();
                System.out.println("Empleado eliminado " + id);
                break;

            // Display a list (Read the records) of Employees
            case 'L':
                Empleado[] allEmps = dao.getAllEmpleados();
                for (Empleado employee : allEmps) {
                    System.out.println(employee + "\n");
                }
                break;
        }

        return false;
    }

    public static Empleado inputEmployee(BufferedReader in) throws IOException {
        return inputEmployee(in, null, true);
    }

    public static Empleado inputEmployee(BufferedReader in, Empleado empDefaults) throws IOException {
        return inputEmployee(in, empDefaults, false);
    }

    public static Empleado inputEmployee(BufferedReader in, Empleado empDefaults, boolean newEmployee) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        int id = -1;
        String firstName;
        String lastName;
        Date birthDate = null;
        Empleado emp;
        float salary;

        if (newEmployee) {
            do {
                System.out.println("Ingrese valor entero para employee id: ");
                try {
                    id = new Integer(in.readLine().trim());
                    if (id < 0) {
                        System.out.println("Por favor, reintente con un valor entero positivo para id");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, reintente con un valor entero positivo para id");
                }
            } while (id < 0);
        } else {
            id = empDefaults.getId();
            System.out.println("Modifique los campos del registro Empleado: " + id
                    + ". Presione return para aceptar el valor actual.");
        }

        String prompt = "Ingrese el valor para el nombre" + ((empDefaults == null) ? "" : " [" + empDefaults.getNombres()+ "]");

        do {
            System.out.println(prompt + " : ");
            firstName = in.readLine().trim();
            if (firstName.equals("") && empDefaults != null) {
                firstName = empDefaults.getNombres();
            }
            if (firstName.length() < 1) {
                System.out.println("Por favor, ingrese un valor valido para nombres");
            }
        } while (firstName.length() < 1);


        prompt = "Ingrese valor para apellidos" + ((empDefaults == null) ? "" : " [" + empDefaults.getApellidos()+ "]");
        do {
            System.out.println(prompt + " : ");
            lastName = in.readLine().trim();
            if (lastName.equals("") && empDefaults != null) {
                lastName = empDefaults.getApellidos();
            }
            if (lastName.length() < 1) {
                System.out.println("Por favor, ingrese un valor valido para apellidos");
            }
        } while (lastName.length() < 1);


        prompt = "Ingrese un valor valido para fecha de nacimiento (" + df.toLocalizedPattern() + ")"
                + ((empDefaults == null) ? "" : " [" + df.format(empDefaults.getFechaNacimiento()) + "]");
        do {
            System.out.println(prompt + " : ");
            String dateStr = in.readLine().trim();
            if (dateStr.equals("") && empDefaults != null) {
                birthDate = empDefaults.getFechaNacimiento();
            } else {
                birthDate = null;
                try {
                    birthDate = new Date(df.parse(dateStr).getTime());
                } catch (ParseException e) {
                    System.out.println("Por favor, ingrese un valor valido para fecha de nacimiento: " + e.getMessage());
                }
            }
        } while (birthDate == null);


        prompt = "Ingrese sueldo del empleado"
                + ((empDefaults == null) ? "" : " [" + nf.format((double) empDefaults.getSueldo()) + "]");
        do {
            System.out.println(prompt + " : ");
            salary = 0;
            try {
                String amt = in.readLine().trim();
                if (!amt.equals("")) {
                    salary = Float.parseFloat(amt);
                }
                if (salary == 0 && empDefaults != null) {
                    salary = empDefaults.getSueldo();
                }
                if (salary < 0) {
                    System.out.println("Por favor, ingrese un valor positivo para sueldo");
                    salary = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un valor valido para sueldo: " + e.getMessage());
            }
        } while (salary == 0);

        // Create an Employee object
        emp = new Empleado(id, firstName, lastName, birthDate, salary);
        return emp;
    }
}