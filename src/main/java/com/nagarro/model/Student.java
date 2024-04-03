package com.nagarro.model;

import javax.persistence.*;

//jpa annotaions to map model to relational database model
@Entity
@Table(name = "students")
public class Student {
    @Id
    private long rollNo;
    private String name;
    private String dob;
    private int score;

    public Student() {

    }
    public Student(long rollNo,String name,String dob,int score) {
        super();
        this.rollNo=rollNo;
        this.name = name;
        this.dob = dob;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRollNo() {
        return rollNo;
    }

    public void setRollNo(long rollNo) {
        this.rollNo = rollNo;
    }
}
