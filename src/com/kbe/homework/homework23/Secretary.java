package com.kbe.homework.homework23;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Secretary {
    private String name;
    private String surname;

    public Secretary(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public Map<Pupil.Gender, ArrayList<Pupil>> divideIntoGroups(ArrayList<Pupil> pupils) {
        return pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
    }


    public Integer findTheMiddleAge(ArrayList<Pupil> pupils) {
        double ageD = pupils.stream()
                .collect(Collectors.averagingInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear()));
        return (int) ageD;
    }


    public Pupil findYoungest(ArrayList<Pupil> pupils) {
        return pupils.stream()
                .max(Comparator.comparing(Pupil::getBirth)).get();
    }


    public Pupil findOldest(ArrayList<Pupil> pupils) {
        return pupils.stream()
                .min(Comparator.comparing(Pupil::getBirth)).get();
    }


    public Map<Integer, ArrayList<Pupil>> divideIntoGroupsByAge(ArrayList<Pupil> pupils) {
        return pupils.stream()
                .collect(Collectors.groupingBy(age -> age.getBirth().getYear(), Collectors.toCollection(ArrayList::new)));
    }


    public void printUniqueNamePupil(ArrayList<Pupil> pupils) {
        pupils.stream()
                .collect(Collectors.toMap(
                        Pupil::getName,
                        Pupil::getBirth
                )).forEach((pupil, dateOfBirth) -> System.out.println(pupil + " - " + dateOfBirth));
    }


    public List<Pupil> getSortedByGenderAndDateAndName(ArrayList<Pupil> pupils) {
        return pupils.stream()
                .sorted(Comparator.comparing(Pupil::getGender).thenComparing(Pupil::getBirth).thenComparing(Pupil::getName).reversed())
                .collect(Collectors.toList());
    }


    public void printPupilsFromTo(ArrayList<Pupil> pupils, int from, int to) {
        int nowYear = LocalDate.now().getYear();
        pupils.stream()
                .filter(pupil -> nowYear - pupil.getBirth().getYear() >= from
                        && nowYear - pupil.getBirth().getYear() < to)
                .forEach(System.out::println);
    }


    public ArrayList<Pupil> getPupilsWithSomeName(ArrayList<Pupil> pupils, String name) {
        return pupils.stream()
                .filter(pupil -> pupil.getName().equalsIgnoreCase(name))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public Map<Pupil.Gender, Integer> getPupilsSortedByAgeSum(ArrayList<Pupil> pupils) {
//        Map<Pupil.Gender, List<Pupil>>  map = pupils.stream()
//                .collect(Collectors.groupingBy(
//                        Pupil::getGender
//                )).entrySet()
//                .stream().collect();
        return null;
    }
}