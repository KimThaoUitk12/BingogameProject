package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void updateById(int id, Employee emp) {
        Optional<Employee> e = employeeRepository.findById(id);
        if (e.isPresent()) {
            e.get().setId(emp.getId());
            e.get().setBadgeNumber(emp.getBadgeNumber());
            e.get().setBirthDay(emp.getBirthDay());
            e.get().setEmail(emp.getEmail());
            e.get().setName(emp.getName());
            e.get().setImage(emp.getImage());
            employeeRepository.save(e.get());
        }
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.isPresent() ? employee.get() : null;
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public void delEmployee(int id) {
        employeeRepository.deleteById(id);
    }


}
