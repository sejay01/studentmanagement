package com.example.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Sid;


    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Course cannot be null")
    private String course;

    public Student() { }

    public Student(int sid, String name, String email, String course) {
        Sid = sid;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
