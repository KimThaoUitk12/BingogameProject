package com.example.demo.controller;

import  com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    private List<Employee> list;

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @RequestMapping(value = "/welcome")
    public @ResponseBody
    Iterable<Employee> welcome(){
        return employeeServiceImpl.findAll();
    }

    @RequestMapping(value = "/delEmp/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable String id){
       employeeServiceImpl.delEmployee(Integer.parseInt(id));
    }

//    @PostMapping(value = "/addEmployee")
//    public void addEmployee(@RequestBody Employee emp){
    @RequestMapping(path = "/addEmployee", method = RequestMethod.POST,consumes = {"application/json"})

    public @ResponseBody void addEmployee(@RequestBody Employee e){

       // Employee e=new Employee(id,name,email,birthDay,badgeNumber,image);

        employeeServiceImpl.addEmployee(e);
//        if(emp != null){
//            Employee addEmp= emp;
//            list.add(addEmp);
//        }

    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee emp, @PathVariable int id){

    }

    public EmployeeController() {
//        Employee emp1=new Employee(1,"employee1","email1","01/01/2020",1,"image1");
//        Employee emp2=new Employee(2,"employee2","email1","01/01/2020",1,"image1");
//        Employee emp3=new Employee(3,"employee3","email1","01/01/2020",1,"image1");
//        Employee emp4=new Employee(4,"employee4","email1","01/01/2020",1,"image1");
//        Employee emp5=new Employee(5,"employee5","email1","01/01/2020",1,"image1");
//
//        list=new ArrayList<>();
//
//        list.add(emp1);
//        list.add(emp2);
//        list.add(emp3);
//        list.add(emp4);
//        list.add(emp5);
    }
}
