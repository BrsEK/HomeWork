package com.kbe.homework.homework23;

import java.time.LocalDate;
import java.util.Objects;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }

    private static int number ; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    // TODO: добавить все необходимые методы


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Pupil(String name, Gender gender, LocalDate birth) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        number++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return Objects.equals(name, pupil.name) &&
                gender == pupil.gender &&
                Objects.equals(birth, pupil.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birth);
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}