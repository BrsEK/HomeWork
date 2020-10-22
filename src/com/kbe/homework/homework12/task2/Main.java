package com.kbe.homework.homework12.task2;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Exception[] exepArr = new Exception[9];

        try {
            int[] arr = new int[5];
            arr[7] = 12;
        } catch (Exception e) {
            exepArr[0] = e;
        }

        try {
            String str = null;
            str.trim();
        } catch (Exception e1) {
            exepArr[1] = e1;
        }

        try {
            int number = 1 / 0;
        } catch (Exception e2) {
            exepArr[2] = e2;
        }

        try {
            Object str = "s";
            int number = (Integer) str;
        } catch (Exception e3) {
            exepArr[3] = e3;
        }

        try {
            int[] arr = new int[-1];
        } catch (Exception e4) {
            exepArr[4] = e4;
        }

        try {
            char ch = "one".charAt(5);
        } catch (Exception e5) {
            exepArr[5] = e5;
        }


        for (int i = 0; i < 6; i++) {
            System.out.println(exepArr[i].toString());
        }
    }
}
