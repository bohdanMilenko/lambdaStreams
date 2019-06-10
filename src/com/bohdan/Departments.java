package com.bohdan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Departments {

    private String name;
    private Set<Employees> employees;

    public Departments(String name) {
        this.name = name;
        employees = new HashSet<>();
    }

    public void addEmployee(Employees anyEmployee){
        employees.add(anyEmployee);
    }

    public Set<Employees> getEmployee(){
        return employees;
    }
}
