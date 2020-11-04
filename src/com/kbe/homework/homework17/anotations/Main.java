package com.kbe.homework.homework17.anotations;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        // Task 2
        // 2.1 ---------------------------
        Human human = null;
        try {
            human = ExampleAnnotation.createHumanUsingReflection("Oleg", 31);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(human);

        // 2.2 ---------------------------
        try {
            ExampleAnnotation.setNameUsingReflection("Boris", human);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //2.3 ---------------------------
        System.out.println(human);

   }
}
