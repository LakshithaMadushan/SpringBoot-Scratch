package com.buddy.channel;

import com.buddy.dto.Employee;
import com.buddy.dto.Response;
import com.buddy.service.IEmplyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmplyeeService implements IEmplyeeService
{
    @Autowired
    RestTemplate restTemplate;

    @Override public String getAllEmployees_WithGetForEntity() throws Exception
    {
        ResponseEntity<String> users = restTemplate.getForEntity( "http://dummy.restapiexample.com/api/v1/employees", String.class );
        return users.getBody();
    }

    @Override public List<Employee> getAllEmployees_WithExchange() throws Exception
    {
        ResponseEntity<List<Employee>> response = restTemplate.exchange( "http://www.mocky.io/v2/5d9ad1f13200000f002ae3b0", HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>()
        {
        } );
        return response.getBody();
    }
}
