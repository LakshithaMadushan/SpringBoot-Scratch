package com.buddy.controller;

import com.buddy.util.ConfigurationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("build-info")
@PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true)
public class BuildInfoController
{
    @Autowired
    private Environment environment;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<HashMap> buildInfo()
    {
        ResponseEntity<HashMap> returnResponse = null;
        HashMap<String, String> metaInfo = new HashMap();

        metaInfo.put( "Build-Name:", environment.getProperty( ConfigurationConstants.APP_NAME ) );
        metaInfo.put( "Build-Date:", environment.getProperty( ConfigurationConstants.APP_BUILD_DATE ) );
        metaInfo.put( "Build-Version:", environment.getProperty( ConfigurationConstants.APP_VERSION ) );
        metaInfo.put( "Build-Number:", environment.getProperty( ConfigurationConstants.APP_BUILD_NUMBER ) );

        returnResponse = new ResponseEntity<HashMap>( metaInfo, HttpStatus.OK );
        return returnResponse;
    }


}
