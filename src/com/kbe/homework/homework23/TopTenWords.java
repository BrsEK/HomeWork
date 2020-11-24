package com.kbe.homework.homework23;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class TopTenWords {
    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<>();


        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов

        // содержимое файла может быть любым
        // Map<String, Long> map = Files.lines(Paths.get("sources/task23.txt")) // читаем из файла в stream
        // методы вызывать по цепочке,
        // цепочку не разрывать (пока не получите результирующую мапу)

        try {
            System.out.println(readFromFilesToMap("source/forTop10.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println(map);

    }

    private static Map<String, Long>  readFromFilesToMap(String pathToFile) throws IOException {
        Map<String, Long> wordsMap  = Files.lines(Paths.get(pathToFile))
                .map(line -> line.split("\\W"))
                .flatMap(line -> Arrays.stream(line))
                .collect(HashMap::new, (hashMap, s) -> hashMap.merge(s, (long) 1, Long::sum), HashMap::putAll);
        //  недоделано.
        return wordsMap;
    }
}