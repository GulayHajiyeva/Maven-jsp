package Teacher.entity;

import common.Person;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private String name;
    private String surname;
    private String subject;
    private double salary;

    public Person person;

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Teacher setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Teacher setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Teacher setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return  name + " " + surname +" "+ subject + " "+ salary;
    }

}
