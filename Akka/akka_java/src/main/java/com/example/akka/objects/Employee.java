package com.example.akka.objects;

public class Employee {
    public long id;
    public String name;
    public String dept;

    public Employee(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "[Id:" + this.id + " Name:" + this.name + " Dept:" + this.dept + "]";
    }
}
