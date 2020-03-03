package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public void  updateById(int id, Employee emp);
    public Employee findById(int id);
    public List<Employee> findAll();
    public void addEmployee(Employee emp);
    public void delEmployee(int id);
}
