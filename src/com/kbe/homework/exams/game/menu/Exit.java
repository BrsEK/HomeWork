package com.kbe.homework.exams.game.menu;

import com.kbe.homework.exams.game.Game;

public class Exit implements Command{
    private Game game;

    public Exit(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.exit();
    }
}
