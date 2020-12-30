package com.company.entity;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private double scholarship;
    private double gpa;
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

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {        return "Student { " +
                "id= " + id +
                ", name= " + name  +
                ", surname= " + surname +
                ", age= " + age +
                ", scholarship= " + scholarship +
                ", gpa= " + gpa +
                ", relationship= "+relationship+
                " }";
    }
}
