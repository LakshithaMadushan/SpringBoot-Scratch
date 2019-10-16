package com.buddy.service;

import com.buddy.model.Person;

import java.util.List;

public interface IPersonService
{
    /**
     * @return
     */
    public List<Person> findAllPersons();

    /**
     * @param age
     * @return
     */
    public Person getPersonByAge( int age );

    /**
     * @param age
     * @param name
     * @return
     */
    public Person getPersonByAgeAndName( int age, String name );
}
