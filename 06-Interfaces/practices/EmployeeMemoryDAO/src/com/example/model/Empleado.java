package com.example.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {

    private int id;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private float sueldo;
    // not thread-safe
    

    public Empleado() {
    }

    public Empleado(int id, String nombres, String apellidos,
            Date fechaNacimiento, float sueldo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }



    @Override
    public String toString() {
        return "Empleado ID:   " + getId() + "\n"
                + "Nombre Empleado: " + getNombres() + " " + getApellidos()+ "\n"
                + "Fecha Nacimiento:    " + new SimpleDateFormat("MMM d, yyyy").format(getFechaNacimiento()) + "\n"
                + "Sueldo:        " + NumberFormat.getCurrencyInstance().format((double) getSueldo());
    }

}
