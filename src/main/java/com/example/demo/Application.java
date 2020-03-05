package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//    @Bean
//	CommandLineRunner initDB(EmployeeServiceImpl employeeService){
//	    return args -> {
//	        employeeService.addEmployee(new Employee(11,"name11","email11","2020/01/01",11,"image1"));
//	        employeeService.addEmployee(new Employee(12,"name12","email12","2020/01/01",12,"image2"));
//	        employeeService.addEmployee(new Employee(13,"name13","email13","2020/01/01",13,"image3"));
//        };
//    }


}
