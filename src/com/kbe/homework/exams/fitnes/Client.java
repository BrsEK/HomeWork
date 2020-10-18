package com.kbe.homework.exams.fitnes;

public class Client {
    private String name;
    private String surName;
    private String preference;


    public Client(String name, String surName, String preference) {
        this.name = name;
        this.surName = surName;
        this.preference = preference;
    }


    public String getPreference() {
        return preference;
    }


    public String getName() {
        return name;
    }


    public String getSurName() {
        return surName;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", preference='" + preference + '\'' +
                '}';
    }
}
