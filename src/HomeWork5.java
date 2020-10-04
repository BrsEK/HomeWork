import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork5 {
    //Метод заполняет уникальными данными массив строк
    private  static void fillArrayUniqueValue(String[] array){
        Scanner scanner = new Scanner(System.in);
        int count = 0; // счетчик для подсчета слов
        for (int i = 0; i < array.length;) {
            System.out.println("Введите любое слово ");
            System.out.println("Для выхода введите слово exit");
            String word = scanner.nextLine();
            if (word.compareToIgnoreCase("exit") == 0 || count == array.length){
                break;
            }
            if (noContains(array, word)){
                array[i] = word;
                count++;
                i++;
            }
        }
    }

    // Метод проверяет есть ли указанное слово в массиве строк
    private static boolean noContains(String[] arr, String word){
        for ( String str : arr){
            if (Objects.nonNull(str)){
                if (word.compareToIgnoreCase(str) == 0){
                    return false;
                }
            }
        }
        return true;
    }

    // Метод возвращает количество вхождений в слово
    private static int quantityOfEntry(String word, String word1){
        int countEntry = 0;
        Pattern pattern = Pattern.compile(word1);
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()){
            countEntry++;
        }
        return countEntry;
    }

    /* Метод возвращает true или false в зависимости от того,
    является ли слово палиндромом или нет.
     */
    private  static  boolean isPalindrome(String str){
        str = str.replaceAll("\\W",""); // Убираем любой символ, кроме буквенного, цифрового или знака подчёркивания
        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        String invertedStr = builder.toString();
        return str.equalsIgnoreCase(invertedStr);
    }

    //Метод меняет первую букву на заглавную, а остальные переводит в нижний регистр
    private static String  fixRegister(String word){
        String firstCharacter = word.substring(0,1).toUpperCase();
        String otherCharacters = word.substring(1,word.length()).toLowerCase();
        return  firstCharacter.concat(otherCharacters);
    }

    // Метод возвращает самое длинное слово
    private static String getLongWord(String line){
        String[] words = line.split(" ");
        String longString = words[0];
        //System.out.println(Arrays.toString(words));
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longString.length()){
                longString = words[i];
            }
        }
        return longString;
    }

    public static void main(String[] args) {
          // Задание 1
//        final int N = 10;
//        String[] arr = new String[N];
//        fillArrayUniqueValue(arr);
//        System.out.println(Arrays.toString(arr));

//        // Задание 2
//        System.out.println("Количесвто вхождений в стрку: " + quantityOfEntry("дом домик домой одомашненный", "дом" ));

//        // Задание 3
//        System.out.println(isPalindrome("а роза упала на лапу Азора"));

//        // Задание 4
//        System.out.println(fixRegister("пРиВет"));

//        // Задание 5
//        System.out.println(getLongWord("в предложении все слова разной длины"));

    }
}
