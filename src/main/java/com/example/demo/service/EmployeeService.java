package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    void  updateById(int id, Employee emp);
    Employee findById(int id);
    List<Employee> findAll();
    void addEmployee(Employee emp);
    void delEmployee(int id);
}
