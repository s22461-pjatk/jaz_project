package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private int index_number;
    private String name;
    private String forename;
    private String email;

    public Student() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public int getIndex_number() {
        return index_number;
    }

    public void setIndex_number(int index_number) {
        this.index_number = index_number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index_number=" + index_number +
                ", name='" + name + '\'' +
                ", forename='" + forename + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
