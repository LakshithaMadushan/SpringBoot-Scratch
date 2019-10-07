package com.buddy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Employee
{
    // @JsonProperty("myId")
    private String id;

    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private String employeeName;

    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private String employeeSalary;

    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private String employeeAge;

    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private String profileImage;

    public Employee()
    {
    }

    public Employee( String id, String employeeName, String employeeSalary, String employeeAge, String profileImage )
    {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getEmployeeName()
    {
        return this.employeeName;
    }

    public void setEmployeeName( String employeeName )
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeSalary()
    {
        return this.employeeSalary;
    }

    public void setEmployeeSalary( String employeeSalary )
    {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeAge()
    {
        return this.employeeAge;
    }

    public void setEmployeeAge( String employeeAge )
    {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage()
    {
        return this.profileImage;
    }

    public void setProfileImage( String profileImage )
    {
        this.profileImage = profileImage;
    }
}
