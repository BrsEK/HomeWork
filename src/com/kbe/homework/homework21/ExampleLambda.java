package com.kbe.homework.homework21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ExampleLambda {

    public static void checkInterval(int number, Predicate<Integer> interval){
        if (interval.test(number)){
            System.out.println("Число входит в интервал");
        }else {
            System.out.println("Число не входит в интервал");
        }
    }


    public static void checkQuantityCharacters(String word, Predicate<String> quantity){
        if (quantity.test(word)){
            System.out.println("Слово слишком короткое");
        }else {
            System.out.println("Это слово можно использовать");
        }
    }


    public static int quantityOfSymbols(String word, Function<String, Integer> separator){
        return separator.apply(word);
    }

    public static void printPercentOfNumber(int number, Function<Integer, Double> percent){
        System.out.println("Процент от числа " + number + " = " + percent.apply(number));
    }

    public static int math(int number, UnaryOperator<Integer> operations){
        return operations.apply(number);
    }

    public static ArrayList<Integer> mathList(ArrayList<Integer> list, UnaryOperator<Integer> o1, UnaryOperator<Integer> o2){
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            result.add(o1.andThen(o2).apply(number));
        }
        return result;
    }
}
