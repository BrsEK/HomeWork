package com.kbe.homework.homework25.task1;

import java.util.HashMap;

public class ConsiderThread implements Runnable {
    private HashMap<String, Integer> resultMap;
    private String line;

    public ConsiderThread(HashMap<String, Integer> resultMap, String line) {
        this.resultMap = resultMap;
        this.line = line;
    }


    @Override
    public void run() {
        resultMap.put(Thread.currentThread().getName(), line.split("\\W").length);
    }
}
