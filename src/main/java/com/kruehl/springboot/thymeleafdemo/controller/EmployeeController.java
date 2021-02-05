package com.kruehl.springboot.thymeleafdemo.controller;


import com.kruehl.springboot.thymeleafdemo.entity.Employee;
import com.kruehl.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    private List<Employee> employees;

//    @PostConstruct
//    private void loadData(){
//        Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
//        Employee emp2 = new Employee(2, "Emma", "baumgarten", "leslie@luv2code.com");
//        Employee emp3 = new Employee(3, "Avani", "Gupta", "leslie@luv2code.com");
//
//        employees = new ArrayList<>();
//
//        employees.add(emp1);
//        employees.add(emp2);
//        employees.add(emp3);
//    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";

    }



}
