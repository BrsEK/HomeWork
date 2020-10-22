package com.kbe.homework.homework12.task1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Main {
    public static void main(String[] args) {

        try {
            ExampleException.throwException(Status.ACCESS_DENIED);
        } catch (JarException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "  <------- сработал fileNotFoundException");
        } catch (AccessDeniedException e) {
            try {
                throw new AccessDeniedException("Вывод из Catch");
            } catch (AccessDeniedException accessDeniedException) {
                accessDeniedException.printStackTrace();
            }
        }
    }
}
