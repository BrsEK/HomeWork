package com.kbe.homework.homework17.reflection;

public class Main {
    public static void main(String[] args) {
        String str = "Hello World!!!";
        Integer integer = 6;
        int[] array = new int[]{1, 2, 3};
        Line line = new Line("Line", 10);

        System.out.println(ExampleReflection.toString(array));
        System.out.println(ExampleReflection.toString(str));
        //System.out.println(ExampleReflection.toString(integer));
        //System.out.println(ExampleReflection.toString(line));
    }
}

