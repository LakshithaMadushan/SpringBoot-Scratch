package com.buddy.dto;

public class Student
{
    private String fistName;
    private String lastName;
    private int age;

    public Student()
    {
    }

    public Student( String fistName, String lastName, int age )
    {
        this.fistName = fistName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFistName()
    {
        return this.fistName;
    }

    public void setFistName( String fistName )
    {
        this.fistName = fistName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge( int age )
    {
        this.age = age;
    }
}
