package com.kbe.homework.exams.game.menu;

import com.kbe.homework.exams.game.events.Descriptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save {

    public static void save(Descriptions response){
        File file = new File("source/saves.txt");

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
