package com.kbe.homework.homework17.anotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExampleAnnotation {
    public static Human createHumanUsingReflection(String name, int age) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends Human> humanClass = Human.class;

        if (humanClass.isAnnotationPresent(Config.class)) {
            Constructor<? extends Human> constructorHuman = humanClass
                    .getDeclaredConstructor(String.class, int.class);
            return constructorHuman.newInstance(name, age);
        }
        return null;
    }


    public static void setNameUsingReflection(String name, Human human) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<? extends Object> humanClass = human.getClass();
        Field humanField = humanClass.getDeclaredField("name");
        if (humanField.isAnnotationPresent(Required.class)) {
            Method method = humanClass.getDeclaredMethod("setName",String.class);
            method.invoke(human, name);
        }
    }
}
