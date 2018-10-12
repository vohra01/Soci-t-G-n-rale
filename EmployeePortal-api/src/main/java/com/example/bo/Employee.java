package com.example.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fname;
    private String lname;
    private String gender;
    private Date dob;
    private String department;

    public Date getDob() {
        return dob;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getFname() {
        return fname;
    }

    public String getGender() {
        return gender;
    }

    public String getLname() {
        return lname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
