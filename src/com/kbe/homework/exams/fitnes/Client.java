package com.kbe.homework.exams.fitnes;

import java.util.Objects;

public class Client {
    private String name;
    private String surName;
    private String preference;

    public void setName(String name) {
        if (Objects.isNull(name))
            throw new IllegalArgumentException(InfoMessage.OBJECT_IS_NULL);
        this.name = name.trim();
    }

    public void setSurName(String surName) {
        if (Objects.isNull(name))
            throw new IllegalArgumentException(InfoMessage.OBJECT_IS_NULL);
        this.surName = surName.trim();
    }

    public void setPreference(String preference) {
        if (Objects.isNull(name))
            throw new IllegalArgumentException(InfoMessage.OBJECT_IS_NULL);
        this.preference = preference.trim();
    }


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
