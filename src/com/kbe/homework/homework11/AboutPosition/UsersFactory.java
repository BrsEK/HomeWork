package com.kbe.homework.homework11.AboutPosition;

public class UsersFactory {
    public static User createUser(String fullName, int salary){
        return new User( fullName, salary);
    }
}
