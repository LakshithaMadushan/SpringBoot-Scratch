package com.buddy.controller;

import com.buddy.yamlPropertyObjects.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("YAML-Props")
public class YAMLPropertiesController
{
    @Autowired
    private Config config;

    @RequestMapping(method = RequestMethod.GET)
    public String YAML_Properties()
    {
        return config.toString();
    }
}
