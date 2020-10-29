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

        Comparator<Car> priceComparator = new Car.PriceComparator();
        Comparator<Car> brandComparator = new Car.BrandComparator();
        Comparator<Car> colorComparator = new Car.ColorComparator();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);

        cars.sort(priceComparator);
        System.out.println(cars);

        cars.sort(colorComparator);
        System.out.println(cars);

        cars.sort(brandComparator);
        System.out.println(cars);
    }
}