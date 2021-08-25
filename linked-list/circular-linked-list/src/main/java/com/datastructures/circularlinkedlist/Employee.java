package com.datastructures.circularlinkedlist;

import java.util.Optional;

public class Employee
{
    private String id;
    private String name;

    public Employee(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Employee)
        {
            Employee otherEmp = (Employee) obj;
            return Optional.ofNullable(this.id).orElse("").equals(otherEmp.getId()) &&
                    Optional.ofNullable(this.name).orElse("").equals(otherEmp.getName());
        }

        return super.equals(obj);
    }

    @Override
    public String toString()
    {
        return "[Id: ]" + id + ", Name: " + name + "]";
    }
}
