package com.buddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run( Application.class, args );
    }
}

// Notice how we're using @SpringBootApplication as our primary application configuration class; behind the scenes, that's equivalent to @Configuration, @EnableAutoConfiguration, and @ComponentScan together.