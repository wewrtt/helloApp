package com.example.hello.model;

import android.media.Image;

import java.io.Serializable;

public class Student implements Serializable {
    private  String name,Age,gender;

    public Student() {
    }

    public Student(String name, String age, String gender) {
        this.name = name;
        Age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Age='" + Age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
