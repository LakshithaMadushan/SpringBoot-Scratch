package com.buddy.repository;

import com.buddy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{
    @Query("SELECT p FROM Person p WHERE p.age=?1")
    public Person getPersonByAge( int age );

    @Query("SELECT p FROM Person p WHERE p.age=?1 AND p.name=?2")
    public Person getPersonByAgeAndName( int age, String name );
}
