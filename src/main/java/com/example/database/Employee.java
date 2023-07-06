package com.example.database;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private Date dob;
    private String address;
    private String number;
    //constructor
    public Employee(int id, String name, Date dob, String address, String number) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.number = number;
    }
    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Date getDob() {
        return dob;
    }
    public String getAddress() {
        return address;
    }
    public String getNumber() {
        return number;
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDate(Date dob) {
        this.dob = dob;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    //to string
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name +
                ", dob=" + dob +
                ", address='" + address +
                ", number='" + number +
                '}';
    }
}
