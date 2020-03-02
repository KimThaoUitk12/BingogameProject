package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private List<Employee> list;

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @RequestMapping(value = "/welcome")
    public List<Employee> welcome(){
        return list;
    }

    @RequestMapping(value = "/delEmp/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable String id){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId() == Long.parseLong(id)){
                list.remove(i);
            }
        }
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee emp){
        if(emp != null){
            Employee addEmp= emp;
            list.add(addEmp);
        }
    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee emp, @PathVariable Long id){
        for(int i=0;i< list.size();i++){
            if(list.get(i).getId()==id){
                list.set(i,emp);
            }
        }
    }

    public EmployeeController() {
        Employee emp1=new Employee(1,"employee1","email1","01/01/2020",1,"image1");
        Employee emp2=new Employee(2,"employee2","email1","01/01/2020",1,"image1");
        Employee emp3=new Employee(3,"employee3","email1","01/01/2020",1,"image1");
        Employee emp4=new Employee(4,"employee4","email1","01/01/2020",1,"image1");
        Employee emp5=new Employee(5,"employee5","email1","01/01/2020",1,"image1");

        list=new ArrayList<>();

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);
    }
}
