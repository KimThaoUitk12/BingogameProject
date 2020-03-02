package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(Integer id);
    public List<Employee> findAll();
}
