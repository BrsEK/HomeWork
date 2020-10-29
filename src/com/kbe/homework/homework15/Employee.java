package com.kbe.homework.homework15;
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры


    public Employee(String name, String company, int salary, int age) {
        Objects.requireNonNull(name,"name is not be null");
        Objects.requireNonNull(company,"company is not be null");
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }


    private static String generatorOfStrings(String[] arr){
        int quantityOfElement = arr.length;
        int indexOfElement = (int)(Math.random() * quantityOfElement)  ;
        return arr[indexOfElement];
    }


    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            String name = generatorOfStrings(names);
            String company = generatorOfStrings(companies);
            int salary = (int) (Math.random() * (500000 + 1));
            int age = (int) (Math.random() * ((60 - 21) + 1) + 21);
            employees.add(new Employee(name, company, salary, age)); // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }

    @Override
    public String toString() {
        return "Employee ==> " +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}' + "\n";
    }
}