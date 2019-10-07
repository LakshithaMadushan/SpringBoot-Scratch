package com.buddy.service;

import com.buddy.dto.Employee;
import com.buddy.dto.Response;

import java.util.List;

public interface IEmplyeeService
{
    /**
     * @return String
     * @throws Exception
     */
    public String getAllEmployees_WithGetForEntity() throws Exception;

    public List<Employee> getAllEmployees_WithExchange() throws Exception;
}
