package com.buddy.controller;

import com.buddy.channel.PersonService;
import com.buddy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // ********** not '@Controller'
@RequestMapping(value = "persons")
public class PersonsController
{
    @Autowired
    private PersonService personService;

    @GetMapping("/getAllPersons")   // http://localhost:8081/persons/getAllPersons
    public List<Person> getAllPersons()
    {
        return personService.findAllPersons();
    }

    @GetMapping("/getPersonByAge/{age}")    // http://localhost:8081/persons/getPersonByAge/22
    public Person getPersonByAge( @PathVariable() int age )
    {
        return personService.getPersonByAge( age );
    }

    @GetMapping("/getPersonByAgeAndName/{age}/{name}")    // http://localhost:8081/persons/getPersonByAgeAndName/22/Lakshitha
    public Person getPersonByAge( @PathVariable() int age, @PathVariable("name") String myName )
    {
        return personService.getPersonByAgeAndName( age, myName );
    }
}
