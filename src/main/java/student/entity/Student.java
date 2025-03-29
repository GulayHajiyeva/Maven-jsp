package student.entity;

import common.Person;

public class Student extends Person {
    private String university;

    public String getUniversity(){
        return  university;
    }

    public Student setUniversity(String university){
        this.university=university;
        return this;
    }
}
