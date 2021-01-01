package com.kbe.homework.exams.game;

import com.kbe.homework.exams.game.menu.Exit;
import com.kbe.homework.exams.game.menu.Load;
import com.kbe.homework.exams.game.menu.Menu;
import com.kbe.homework.exams.game.menu.Start;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Menu menu = new Menu(new Start(game), new Load(game), new Exit(game));

        menu.startMenu();
    }
}
