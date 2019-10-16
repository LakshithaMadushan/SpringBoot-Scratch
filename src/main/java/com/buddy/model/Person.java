package com.buddy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int age;

    public Person()
    {
    }

    public Person( Long id, String name, int age )
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge( int age )
    {
        this.age = age;
    }

    @Override public String toString()
    {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
