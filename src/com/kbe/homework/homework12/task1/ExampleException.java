package com.kbe.homework.homework12;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.jar.JarException;

public class ExampleException {
    private int Status;


    static void throwException(Status status)throws JarException, FileNotFoundException, AccessDeniedException {
        switch (status){
            case JAR_ERROR:
                throw new JarException();
            case ACCESS_DENIED:
                throw new AccessDeniedException("AccessDeniedException");
            case FILE_NOT_FOUND:
                throw new FileNotFoundException("Файл не найден");
        }
    }

    public int getStatus() {
        return Status;
    }
}
