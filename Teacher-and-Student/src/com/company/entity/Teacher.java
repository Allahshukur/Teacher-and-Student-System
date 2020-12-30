package com.company.entity;

import java.io.Serializable;

public class Teacher implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private double salary;
    private String chair;
    private String relationship;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "Teacher{ " +
                "id= " + id +
                ", name= " + name +
                ", surname= " + surname +
                ", age= " + age +
                ", salary=" + salary +
                ", chair= " + chair +
                ", relationship= " + relationship +
                " }";
    }
}
