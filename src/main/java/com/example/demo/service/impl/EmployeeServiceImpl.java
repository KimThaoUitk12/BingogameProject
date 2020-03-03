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
       Employee e=new EmployeeServiceImpl().findById(id);
       if(e!=null){
           e.setId(emp.getId());
           e.setBadgeNumber(emp.getBadgeNumber());
           e.setBirthDay(emp.getBirthDay());
           e.setEmail(emp.getEmail());
           e.setName(emp.getName());
           e.setImage(emp.getImage());
           employeeRepository.save(e);
       }

    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.isPresent()?employee.get():null;
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
