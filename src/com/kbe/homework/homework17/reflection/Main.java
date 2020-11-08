package com.kbe.homework.homework17.reflection;

import com.kbe.homework.homework17.anotations.Human;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String str = "Hello World!!!";
        Double myFloat = 6.3;
        Integer myInteger = 6;
        StringBuilder stringBuilder = new StringBuilder();
        int[] array = new int[]{1, 2, 3};
        Line line = new Line("Line", 10);

        try {
            System.out.println(ExampleReflection.toString(line));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int a = 3;
        System.out.println(int.class.isPrimitive());
        //System.out.println(ExampleReflection.toString(integer));
        //System.out.println(ExampleReflection.toString(line));
    }
}

