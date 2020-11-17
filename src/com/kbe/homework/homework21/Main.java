package com.kbe.homework.homework21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        // Task 1 ---------------------------
        // Пример Predicate
        ExampleLambda.checkInterval(5, (a) -> a > 2 && a < 10);
        ExampleLambda.checkQuantityCharacters("Word", (word) -> word.length() < 2);

        // Пример Function
        System.out.println(ExampleLambda.quantityOfSymbols("Word", (word) -> word.length()));
        ExampleLambda.printPercentOfNumber(100, (number) -> number * 0.5);

        // Пример UnaryOperator
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(ExampleLambda.math(5, square));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<Integer> numbers = ExampleLambda.mathList(list, (x) -> x * 2, (x) -> x + 1);
        System.out.println(numbers.toString());

        // Пример Consumer
        list.forEach(a -> System.out.print(a * 2 + " "));
        System.out.println();
        list.forEach(System.out::println);


        //Task 2 -------------------------------
        // Переделал компараторы в homework 15

        // Task 3 ------------------------------
        //  Реализовал метод в University

        // Task 4 ------------------------------
        University university = new University();
        for (int i = 0; i < 10; i++) {
            university.addCourse(Course.getInstance());
        }
        // filters
        // 4.1
        Predicate<Course> filterByDuration = course -> course.getDuration() < 3;
        List<Course> courses1 = university.filtered(filterByDuration);

        // 4.2
        Predicate<Course> filterByPrice = course -> course.getPrice() >= 2000;
        List<Course> courses2 = university.filtered(filterByPrice);

        // 4.3
        Predicate<Course> filterByMonthAndPrice = filterByDuration.and(filterByPrice);
        List<Course> courses3 = university.filtered(filterByMonthAndPrice);

        // 4.4
        Predicate<Course> filterByMonthAndPriceAndName = filterByMonthAndPrice.and(course -> course
                .getName()
                .equalsIgnoreCase("JJD"));
        List<Course> courses4 = university.filtered(filterByMonthAndPriceAndName);

        System.out.println("By month: ");
        courses1.forEach(System.out::println);
        System.out.println("By price: ");
        courses2.forEach(System.out::println);
        System.out.println("By month and price: ");
        courses3.forEach(System.out::println);
        System.out.println("By month and price and name: ");
        courses4.forEach(System.out::println);

        // Task 5 ------------
        university.getCourses().forEach(course -> course.setPrice(course.getPrice() + 10000));
    }
}
