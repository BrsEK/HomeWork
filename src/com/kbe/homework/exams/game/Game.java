package com.kbe.homework.exams.game;

import com.kbe.homework.exams.game.events.Descriptions;
import com.kbe.homework.exams.game.events.Situation;

import java.io.*;
import java.util.HashMap;

public class Game {

    HashMap<Descriptions, Situation> events;

    public Game() {
        events = new HashMap<>();
        initSituations();
    }

    public void start(){
        events.get(Descriptions.FOX).execute(events);
    }

    public void load(){
        File file = new File("source/saves.txt");
        if (file.exists()){
            try (FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
               Descriptions situation = (Descriptions)objectInputStream.readObject();
               events.get(situation).execute(events);
            }
            catch (IOException  | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void exit(){
        System.out.println("Выход из игры");
    }


    private void initSituations(){
        events.put(Descriptions.FOX, new Situation(Descriptions.FOX, Descriptions.GO_HOME, Descriptions.GO_FIND));
        events.put(Descriptions.GO_HOME, new Situation(Descriptions.GO_HOME, Descriptions.STOP, Descriptions.STOP));
        events.put(Descriptions.GO_FIND, new Situation(Descriptions.GO_FIND, Descriptions.FOREST_DWELLERS, Descriptions.SINGLETON));
        events.put(Descriptions.FOREST_DWELLERS, new Situation(Descriptions.FOREST_DWELLERS, Descriptions.OWL, Descriptions.WOLF));
        events.put(Descriptions.SINGLETON, new Situation(Descriptions.SINGLETON, Descriptions.STOP, Descriptions.STOP));
        events.put(Descriptions.OWL, new Situation(Descriptions.OWL, Descriptions.BELIEVE_OWL, Descriptions.SINGLETON));
        events.put(Descriptions.WOLF, new Situation(Descriptions.WOLF, Descriptions.GO_HOME, Descriptions.SINGLETON));
        events.put(Descriptions.BELIEVE_OWL, new Situation(Descriptions.BELIEVE_OWL, Descriptions.SINGLETON, Descriptions.GET_HONEY));
        events.put(Descriptions.GET_HONEY, new Situation(Descriptions.GET_HONEY, Descriptions.WAIT_BEES, Descriptions.STEAL_HONEY));
        events.put(Descriptions.WAIT_BEES, new Situation(Descriptions.WAIT_BEES, Descriptions.EAT, Descriptions.HONEY_FOR_BEAR));
        events.put(Descriptions.STEAL_HONEY, new Situation(Descriptions.STEAL_HONEY, Descriptions.STOP, Descriptions.STOP));
        events.put(Descriptions.HONEY_FOR_BEAR, new Situation(Descriptions.HONEY_FOR_BEAR, Descriptions.GO_FIND, Descriptions.GO_HOME));
        events.put(Descriptions.EAT, new Situation(Descriptions.EAT, Descriptions.STOP, Descriptions.STOP));
    }
}
