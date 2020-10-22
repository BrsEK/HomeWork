package com.kbe.homework.homework12.task1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
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
