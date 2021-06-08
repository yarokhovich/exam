package ru.urllink.jjd.exam2.commands;

import ru.urllink.jjd.exam2.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands = new ArrayList<>();

    public Menu(Game game) {
        commands.add(new StartCommand(game));
        commands.add(new LoadCommand(game));
        commands.add(new ExitGame(game));
    }

    public void activationToConsole() {
        commands.forEach(command -> System.out.println(commands.indexOf(command) + 1 + " " + command.getTitle()));
    }

    public void executeCommand(int indx) {
        commands.get(indx).execute();
    }

    public void runMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            activationToConsole();
            try {
                String line = reader.readLine();
                int choice = Integer.parseInt(line);
                executeCommand(choice - 1);
                break;
            } catch (IOException e) {
                System.out.println("Error " + e);
            } catch (IndexOutOfBoundsException | NumberFormatException d) {
                System.out.println("Введите значение соответсвующее пункту меню");
            }

        }
    }
}

