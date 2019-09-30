package com.buddy.dto;

public class User
{
    private int id;
    private String email;
    private String fName;
    private String lName;
    private String avatar;

    public User()
    {
    }

    public User( int id, String email, String fName, String lName, String avatar )
    {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.avatar = avatar;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getfName()
    {
        return this.fName;
    }

    public void setfName( String fName )
    {
        this.fName = fName;
    }

    public String getlName()
    {
        return this.lName;
    }

    public void setlName( String lName )
    {
        this.lName = lName;
    }

    public String getAvatar()
    {
        return this.avatar;
    }

    public void setAvatar( String avatar )
    {
        this.avatar = avatar;
    }
}
