package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/")
    public String home(){
        return "Hello World!";
    }

//    @GetMapping("/redirected")
//    public String redirect(){
//        return "Page after login";
//    }

    @GetMapping(value = "/welcome")
    public @ResponseBody
    Iterable<Employee> welcome(){
        return employeeServiceImpl.findAll();
    }

    @DeleteMapping(value = "/delEmp/{id}")
    public void deleteEmployee(@PathVariable String id){
       employeeServiceImpl.delEmployee(Integer.parseInt(id));
    }

    @PostMapping(path = "/addEmployee",consumes = {"application/json"})
    public @ResponseBody void addEmployee(@RequestBody Employee e){

        employeeServiceImpl.addEmployee(e);

    }

    @PutMapping(value = "/updateEmployee/{id}")
    public void updateEmployee(@RequestBody Employee emp, @PathVariable int id){
        employeeServiceImpl.updateById(id,emp);
    }

    @GetMapping(value = "/findOne/{id}")
    public @ResponseBody
    Employee findOne(@PathVariable int id){
        return employeeServiceImpl.findById(id);
    }


}
