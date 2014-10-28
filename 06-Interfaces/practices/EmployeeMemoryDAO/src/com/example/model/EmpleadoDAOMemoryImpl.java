/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josediaz
 */
public class EmpleadoDAOMemoryImpl implements EmpleadoDAO{

    private static Empleado[] empleadoArray =
            new Empleado[10];
    
    @Override
    public void add(Empleado emp) {
        empleadoArray[emp.getId()] = emp;
    }

    @Override
    public void update(Empleado emp) {
        empleadoArray[emp.getId()] = emp;
    }

    @Override
    public void delete(int id) {
        empleadoArray[id] = null;
    }

    @Override
    public Empleado findById(int id) {
        return empleadoArray[id];
    }

    @Override
    public Empleado[] getAllEmpleados() {
        List<Empleado> emps = new ArrayList<>();
        for(Empleado e: empleadoArray){
            if(e!=null){
                emps.add(e);
            }
        }
        return emps.toArray(new Empleado[0]);
    }
    
}
