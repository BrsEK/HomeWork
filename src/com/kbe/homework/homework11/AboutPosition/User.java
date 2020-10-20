package com.kbe.homework.homework11.AboutPosition;

import java.util.Objects;

public class User {
    private String fullName;
    private int salary;
    private Position position;

    public Position getPosition() {
        return position;
    }


    public User(String fullName, int salary) {
        setFullName(fullName);
        setSalary(salary);
        setPosition(position);
    }


    private void setFullName(String fullName) {
        Objects.requireNonNull(fullName, "Object is Null");
        this.fullName = fullName;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }


    public void setPosition(Position position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}
