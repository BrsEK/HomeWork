package com.kbe.homework.homework23;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class PupilTask {
    public static void main(String[] args) {

        PupilsSecretary secretary = new PupilsSecretary("Egor", "Ivanovich");

        // обращение к enum Gender через имя класса - Pupil.Gender
        ArrayList<Pupil> pupils = new ArrayList<>();
        pupils.add(new Pupil("Vasya", Pupil.Gender.MALE, LocalDate.of(1997, Month.APRIL,10)));
        pupils.add(new Pupil("Vasya", Pupil.Gender.MALE, LocalDate.of(1995, Month.OCTOBER,12)));
        pupils.add(new Pupil("Lena", Pupil.Gender.FEMALE, LocalDate.of(1996, Month.MARCH,15)));
        pupils.add(new Pupil("Oleg", Pupil.Gender.MALE, LocalDate.of(1995, Month.MAY,1)));
        pupils.add(new Pupil("Ilya", Pupil.Gender.MALE, LocalDate.of(1996, Month.JUNE,17)));
        pupils.add(new Pupil("Olya", Pupil.Gender.FEMALE, LocalDate.of(1995, Month.SEPTEMBER,30)));
        pupils.add(new Pupil("Denis", Pupil.Gender.MALE, LocalDate.of(1996, Month.APRIL,11)));
        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        System.out.println("Женские и мужские группы:");
        System.out.println(secretary.divideIntoGroups(pupils));

        // 2. Найти средний возраст учеников
        System.out.println("Средний возраст учеников");
        System.out.println(secretary.findTheMiddleAge(pupils));

        // 3. Найти самого младшего ученика
        System.out.println("Самый младший ученик:");
        System.out.println(secretary.findYoungest(pupils));

        // 4. Найти самого старшего ученика
        System.out.println("Самый старший ученик:");
        System.out.println(secretary.findOldest(pupils));

        // 5. Собрать учеников в группы по году рождения
        System.out.println("Сортировка по году рождения:");
        System.out.println(secretary.divideIntoGroupsByAge(pupils));

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        System.out.println("Вывод учеников с уникальными именами:");
        secretary.printUniqueNamePupil(pupils);

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        System.out.println("Сортировка по полу, дате рождения, имени(в обратном порядке)");
        System.out.println(secretary.getSortedByGenderAndDateAndName(pupils));

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        System.out.println("From age to age:");
        secretary.printPupilsFromTo(pupils,20, 30);

        // 9. Собрать в список всех учеников с именем=someName
        System.out.println("список всех учеников с именем Vasya");
        System.out.println(secretary.getPupilsWithSomeName(pupils, "Vasya"));

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
    }
}