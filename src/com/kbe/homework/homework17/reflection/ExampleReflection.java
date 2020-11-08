package com.kbe.homework.homework17.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Objects;

public class ExampleReflection {

    public static String toString(Object o) throws IllegalAccessException {
        Objects.requireNonNull(o, "Object is not be null");

        Class<? extends Object> someClass = o.getClass();

        StringBuilder stringBuilderInfo = new StringBuilder();

        if (someClass.isArray()) {
            stringBuilderInfo.append("{ ");
            for (int i = 0; i < Array.getLength(o); i++) {
                stringBuilderInfo.append(Array.get(o, i));
                stringBuilderInfo.append(", ");
            }
            stringBuilderInfo.append("}");
            return stringBuilderInfo.toString();
        }

        if (o instanceof String
                || o instanceof Byte
                || o instanceof Integer
                || o instanceof Long
                || o instanceof Double
                || o instanceof Float
                || o instanceof Boolean
        ) {
            return o.toString();
        }

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            stringBuilderInfo
                    .append(field.getName())
                    .append(": ")
                    .append(toString(field.get(o)))
                    .append("\n");
        }
        return stringBuilderInfo.toString();
    }
}

