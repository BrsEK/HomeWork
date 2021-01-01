package com.kbe.homework.exams.game.menu;

import com.kbe.homework.exams.game.Game;

public class Load implements Command{
    private Game game;

    public Load(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.load();
    }
}
