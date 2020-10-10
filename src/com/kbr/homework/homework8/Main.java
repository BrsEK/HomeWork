package com.kbr.homework.homework8;

public class Main {
    public static void main(String[] args) {
        Teacher teacherOfmathematic = new Teacher("Иван Петрович", 50, "Математика");
        Teacher teacherOfHistory = new Teacher("Олег Игоревич", 40, "История");
//        Teacher teacherOfGeography = new Teacher("Игорь Владимирович", 55, "География");

        SchoolBoy schoolBoy1 = new SchoolBoy("Владимир", 10, "Математика");
        SchoolBoy schoolBoy2 = new SchoolBoy("Александр", 11, "История");
        SchoolBoy schoolBoy3 = new SchoolBoy("Олег", 12, "География");

        Director director = new Director("Степан Николаевич",60);

        School school = new School("Школа №115", director);
//        school.addTeacher(teacherOfGeography);
        school.addTeacher(teacherOfHistory);
        school.addTeacher(teacherOfmathematic);
        school.addSchoolBoy(schoolBoy1);
        school.addSchoolBoy(schoolBoy2);
        school.addSchoolBoy(schoolBoy3);

        System.out.println(school.toString());

        school.dayOnTheSchool();
        teacherOfHistory.teach(director);
        System.out.println(school.toString());
    }
}
