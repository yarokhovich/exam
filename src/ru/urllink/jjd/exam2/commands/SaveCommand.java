package ru.urllink.jjd.exam2.commands;

import ru.urllink.jjd.exam2.Game;

public class SaveCommand implements Command{
    private    Game game;

    public SaveCommand(Game game) {
        this.game = game;
    }
    @Override
    public void execute() {
        game.saveGame();
    }


    @Override
    public String getTitle() {
        return "Сохранить игру";
    }
}
