package com.kbe.homework.homework16;

import java.lang.reflect.Array;
import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        List<String> listOfCities = new ArrayList<>();
        listOfCities = getListOfCities(firstTaskMap, city);

        System.out.print("Логины соответствующие городу " + city + ": ");
        System.out.println(listOfCities);


        // TODO:: дан список слов (words).
        //  Написать метод, который будет возвращать количество
        //  одинаковых слов с списке
        //  в виде Map<String, Integer>,
        //  где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println("Список повторений: " + getLoginsOfCity(words));


        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели,
        //  возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println("from 20 to 50 " + getByAge(customerMap, 20, 50));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        String word = "uncover";
        System.out.println("Слово " + "\"" + word + "\"" + " встречается в тексте " + getFrequencyWord(text, word) + " раз");

        System.out.println(groupWordsByRepetitions(text));

        printTopFrequencyWords(text);

        printFrequencyEnglishWords(text);
    }


    private static Map<String, Integer> getLoginsOfCity(List<String> words) {
        Map<String, Integer> mapSameWords = new HashMap<>();
        for (String word : words) {
            if (mapSameWords.containsKey(word)) {
                mapSameWords.put(word, mapSameWords.get(word) + 1);
            } else {
                mapSameWords.put(word, +1);
            }
        }
        return mapSameWords;
    }


    private static List<String> getListOfCities(HashMap<String, String> firstTaskMap, String city) {
        List<String> listOfCities = new ArrayList<>();
        for (Map.Entry<String, String> citySet : firstTaskMap.entrySet()) {
            if (citySet.getValue().equalsIgnoreCase(city))
                listOfCities.add(citySet.getKey());
        }
        return listOfCities;
    }


    public static HashMap<String, Customer> getByAge(
            HashMap<String, Customer> map,
            int from, int to
    ) {
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> entry : map.entrySet()) {
            if (entry.getValue().getAge() >= from &&
                    entry.getValue().getAge() < to) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }


    private static int getFrequencyWord(String text, String word) {
        return Collections.frequency(Arrays.asList(text.split("\\W")), word);
    }


    private static HashMap<Integer, HashSet<String>> groupWordsByRepetitions(String text) {
        HashMap<Integer, HashSet<String>> groupWords = new HashMap<>();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split("\\W")));
        for (String word : words) {
            if (groupWords.containsKey(word.length())) {
                groupWords.get(word.length()).add(word);
            } else {
                groupWords.put(word.length(), new HashSet<>());
                groupWords.get(word.length()).add(word);
            }
        }
        return groupWords;
    }


    private static void printTopFrequencyWords(String text) {
        List<String> textList = Arrays.asList(text.split("\\W"));
        TreeMap<Integer, String> sortedWord = new TreeMap<>();
        for (String word : textList) {

            sortedWord.put(Collections.frequency(textList, word), word);
        }
        System.out.println(sortedWord);
    }


    private static void printFrequencyEnglishWords(String text) {
        String textWithoutSpace = text.replaceAll("\\W", "");
        List<String> textArray = Arrays.asList(textWithoutSpace);
        HashMap<Character, Integer> infoMap = new HashMap<>();
        int quantityOfCharacter = textWithoutSpace.length();
        char[] chars = textWithoutSpace.toUpperCase().toCharArray();
        for (char iChar : chars) {
            if (infoMap.containsKey(iChar)) {
                infoMap.put(iChar, infoMap.get(iChar) + 1);
            } else {
                infoMap.put(iChar, 1);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : infoMap.entrySet()) {
            int percent = (characterIntegerEntry.getValue() / quantityOfCharacter) * 100;
            System.out.println(characterIntegerEntry.getKey() + " " + characterIntegerEntry.getValue() + " %");
        }
    }
}