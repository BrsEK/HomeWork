package com.kbe.homework.homework23;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PupilsSecretary {
    private String name;
    private String surname;

    public PupilsSecretary(String name, String surname) {
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
        return null;//pupils.stream()
        // .collect(Collectors.groupingBy(Pupil::getGender, Collectors.summingInt(pupil -> pupil.getBirth().getYear()))
    }
}
