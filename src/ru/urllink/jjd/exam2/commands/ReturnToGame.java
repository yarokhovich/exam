package ru.urllink.jjd.exam2.commands;

import ru.urllink.jjd.exam2.Game;

public class ReturnToGame implements Command{
    private   Game game;

    public ReturnToGame(Game game) {
        this.game = game;
    }
    @Override
    public void execute() {
     game.returnToGame();
    }

    @Override
    public String getTitle() {
        return "Вернуться в игру";
    }
}
