package com.kbe.homework.homework19;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File file = new File("source/exampleCrypt.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EncryptDataClass.printEncryptedDataToFile(file,"Hello World", "KBE");

        System.out.println(EncryptDataClass.getDecryptedDataFromFile(file,"KBE"));

    }
}
