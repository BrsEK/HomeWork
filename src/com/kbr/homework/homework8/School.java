package com.kbr.homework.homework8;

import java.util.Arrays;
import java.util.Objects;

public class School{
    private final String name;
    private Teacher[] teachers;
    private SchoolBoy[] schoolBoys;

    public void setDirector(Director director) {
        this.director = director;
    }

    private Director director;

    public School(String name, Director director) {
        this.name = name;
        this.director = director;
        teachers = new Teacher[NumberPersons.QUANTITY_OF_TEACHERS];
        schoolBoys = new SchoolBoy[NumberPersons.QUANTITY_OF_SCHOOLBOYS];
    }

    public void dayOnTheSchool(){
        director.announceStartOfLessons();
        studyingProcess();
        director.announceEndOfLessons();
    }

    private void studyingProcess(){
        for (int i = 0; i < teachers.length; i++) {
            for (int j = 0; j < schoolBoys.length; j++) {
                if (teachers[i].getSubjectTaught().equalsIgnoreCase(schoolBoys[j].getSubjectUnderStudy())){
                    teachers[i].teach(schoolBoys[j]);
                }
            }
        }
    }

    public void addTeacher(Teacher teacher){
        for (int i = 0; i < teachers.length; i++) {
            if (Objects.isNull(teachers[i])){
                teachers[i] = teacher;
                return;
            }
        }
    }


    public void addSchoolBoy(SchoolBoy schoolBoy){
        for (int i = 0; i < schoolBoys.length; i++) {
            if (Objects.isNull(schoolBoys[i])){
                schoolBoys[i] = schoolBoy;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", teachers=" + Arrays.toString(teachers) +
                ", schoolBoys=" + Arrays.toString(schoolBoys) +
                ", director=" + director +
                '}';
    }
}
