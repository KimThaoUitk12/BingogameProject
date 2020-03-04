package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(path = "/addEmployee", method = RequestMethod.POST,consumes = {"application/json"})
    public @ResponseBody void addEmployee(@RequestBody Employee e){

        employeeServiceImpl.addEmployee(e);

    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee emp, @PathVariable int id){
        employeeServiceImpl.updateById(id,emp);
    }

    @RequestMapping(value = "/findOne/{id}")
    public @ResponseBody
    Employee findOne(@PathVariable int id){
        return employeeServiceImpl.findById(id);
    }


    public EmployeeController() {
    }
}
