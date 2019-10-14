package com.buddy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BuildInfoController.class)
public class BuildInfoControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void buildInfo_CheckFullResponse() throws Exception
    {
        mockMvc.perform( get( "/build-info" ) )
                .andDo( print() )
                .andExpect( status().isOk() )
                .andExpect( content().json( "{\"Build-Date:\":\"2019-10-08T11:18:46.504Z\",\"Build-Name:\":\"testing\",\"Build-Version:\":\"1.0-SNAPSHOT\",\"Build-Number:\":null}" ) );
    }

    @Test
    public void buildInfo_ContentType() throws Exception
    {
        mockMvc.perform( get( "/build-info" ) )
                .andDo( print() )
                .andExpect( status().isOk() )
                .andExpect( content().contentType( MediaType.APPLICATION_JSON_UTF8 ) );
    }
}