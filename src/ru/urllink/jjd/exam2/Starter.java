package ru.urllink.jjd.exam2;

import ru.urllink.jjd.exam2.commands.Menu;

public class Starter {
    public static void main(String[] args) {

        Game game = new Game();
        Menu menu = new Menu(game);
        menu.runMenu();


    }

}
