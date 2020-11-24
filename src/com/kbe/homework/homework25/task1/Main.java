package com.kbe.homework.homework25.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> textLines = null;
        try {
            textLines = Files.readAllLines(Paths.get("source/forMultithreading.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, Integer> resultMap = new HashMap<>();

        for (String line : textLines) {
           Thread thread =  new Thread(new ConsiderThread(resultMap, line));
           thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        resultMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> System.out.println(entry.getKey() + " " +  entry.getValue() + " слов"));
    }
}
