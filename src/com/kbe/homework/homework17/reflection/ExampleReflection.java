package com.kbe.homework.homework17.reflection;

import java.lang.reflect.Field;

public class ExampleReflection {


    public static String toString(Object o){
        Class<? extends Object>someClass = o.getClass();

        StringBuilder stingBuilderInfo = new StringBuilder();

        for (Field field : someClass.getDeclaredFields()) {
            field.setAccessible(true);
            stingBuilderInfo.append(makeColorString("Field -----------------------"));
            stingBuilderInfo.append("\n");
            stingBuilderInfo.append(" ");
            stingBuilderInfo.append(field.getName());
            stingBuilderInfo.append(" - ");
            try {
                stingBuilderInfo.append(field.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            stingBuilderInfo.append("\n");
        }

        return stingBuilderInfo.toString();
    }


    private static  String makeColorString(String str){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        return ANSI_GREEN + str + ANSI_RESET;
    }
}
