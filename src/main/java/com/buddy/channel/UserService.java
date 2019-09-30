package com.buddy.channel;

import com.buddy.dto.MyResponse;
import com.buddy.dto.User;
import com.buddy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService implements IUserService
{
    @Autowired
    RestTemplate restTemplate;

    @Override public String getAllUsers_WithGetForEntity() throws Exception
    {
        ResponseEntity<String> users = restTemplate.getForEntity( "http://localhost:8081/test", String.class );
        return users.getBody();
    }
}
