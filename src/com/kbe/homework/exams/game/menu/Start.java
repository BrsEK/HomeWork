package com.kbe.homework.exams.game.menu;

import com.kbe.homework.exams.game.Game;

public class Start implements Command{
    private Game game;

    public Start(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }
}
