/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author josediaz
 */
public interface EmpleadoDAO {
    
    public void add(Empleado emp);
    public void update(Empleado emp);
    public void delete(int id);
    public Empleado findById(int id);
    public Empleado[] getAllEmpleados(); 
    
}
