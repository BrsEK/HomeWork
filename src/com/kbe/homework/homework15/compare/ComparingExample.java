package com.kbe.homework.homework15.compare;

import java.awt.event.ComponentAdapter;
import java.util.*;

public class ComparingExample {
    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);


        ArrayList<Car> cars = new ArrayList<>();
        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);


        cars.sort(Comparator.comparing(Car::getPrice));
        System.out.println(cars);

        cars.sort(Comparator.comparing(Car::getColor));
        System.out.println(cars);

        cars.sort(Comparator.comparing(Car::getBrand));
        System.out.println(cars);
    }
}