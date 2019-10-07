package com.buddy.controller;

import com.buddy.channel.EmplyeeService;
import com.buddy.dto.Employee;
import com.buddy.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController   // @Controller - error resolving template
@RequestMapping("employees")
public class EmployeeController
{
    @Autowired
    EmplyeeService userService;

    @GetMapping("/getAllEmployees_WithGetForEntity")
    public String getAllEmployees_WithGetForEntity() throws Exception
    {
        return userService.getAllEmployees_WithGetForEntity();
    }

    @GetMapping("/getAllEmployees_WithExchange")
    public List<Employee> getAllEmployees_WithExchange() throws Exception
    {
        List<Employee> allEmployees = userService.getAllEmployees_WithExchange();
        // [{"id":"1","employeeName":null,"employeeSalary":null,"employeeAge":null,"profileImage":null}]

        return allEmployees;
    }
}
