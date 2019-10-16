package com.buddy.channel;

import com.buddy.model.Person;
import com.buddy.repository.PersonRepository;
import com.buddy.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService
{
    @Autowired
    private PersonRepository personRepository;

    @Override public List<Person> findAllPersons()
    {
        return personRepository.findAll();
    }

    @Override public Person getPersonByAge( int age )
    {
        return personRepository.getPersonByAge( age );
    }

    @Override public Person getPersonByAgeAndName( int age, String name )
    {
        return personRepository.getPersonByAgeAndName( age, name );
    }
}
