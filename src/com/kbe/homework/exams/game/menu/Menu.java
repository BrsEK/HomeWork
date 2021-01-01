package com.kbe.homework.exams.game.menu;

import java.util.Scanner;

public class Menu {
    private Command start, load, exit;

    public Menu(Command start, Command load, Command exit) {
        this.start = start;
        this.load = load;
        this.exit = exit;
    }

    public void startMenu(){
        System.out.println("Ирга про путешествие лисенка");
        System.out.println("0 - Играть" + "\n" + "1 - Загрузить" + "\n" + "2 - Выход" );
        int response = Integer.parseInt(new Scanner(System.in).nextLine());
        switch (response){
            case 0:
                startGame();
                break;
            case 1:
                loadGame();
                break;
            case 2:
                exitGame();
                break;
        }
    }

    public void startGame(){
        start.execute();
    }

    public void loadGame(){
        load.execute();
    }

    public void exitGame(){
        exit.execute();
    }


}
