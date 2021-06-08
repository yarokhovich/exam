package ru.urllink.jjd.exam2;

import ru.urllink.jjd.exam2.commands.GameMenu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game {
    GameMenu menu = new GameMenu(this);

    static final String srcGame = "src/ru/urllink/jjd/exam2/res/story.md";
    static final String saveFile="src/ru/urllink/jjd/exam2/res/save.txt";
    private String currentLvl;
    private Boolean startFlag=false;
    private Boolean stopFlag=false;
    private Boolean gameOver=false;

    public void startGame(){
        System.out.println("Старт");
        story("### Лисенок");
    }
    public void exitGame(){

        System.exit(0);
    }
    public void loadGame(){
        try {
            story(Files.readString(Paths.get(saveFile)));
             } catch (IOException e) {
            System.out.println("Ошибка загрузки сохранения "+e);
        }
    }
    public void saveGame(){
        try {
            Files.writeString(Paths.get(saveFile), currentLvl);
            System.out.println("Игра сохранена");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения "+e);
        } returnToGame();
    }
    public void returnToGame(){
        story(currentLvl);
    }
    public void story(String begin) {
        try {
            Files.lines(Paths.get(srcGame)).forEach(s -> {
                if (s.compareTo(begin) == 0) {
                    startFlag = true;
                }
                if (s.startsWith("###") && s.compareTo(begin) != 0 && startFlag) {
                    stopFlag = true;
                }
                if (startFlag && !stopFlag) {
                    if (s.contains("</b>"))
                    {
                        gameOver=true;
                    }
                    System.out.println(s);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        startFlag = false;
        stopFlag = false;

        System.out.println("****************");
        if (gameOver) {
            System.exit(-1);
        }else {
            System.out.println("0. Выйти в меню");
            setCurrentLvl(begin);
            gameConsoleIn ();
        }
    }
    public void setCurrentLvl ( String currentLvl){
        this.currentLvl = currentLvl;
    }

    public void gameConsoleIn () {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
               try {
                String line = reader.readLine();
                int choice = Integer.parseInt(line);
                   switch (choice) {
                       case 1 -> switcher1();
                       case 2 -> switcher2();
                       case 0 -> menu.runMenu();
                   }
                   break;
            } catch (IOException e) {
                System.out.println("Error " + e);
            } catch (IndexOutOfBoundsException | NumberFormatException d) {
                System.out.println("Введите значение соответсвующее варианту выбора");
            }
        }
    }
    private void switcher1() {
        String nextLvl = "";
        if (currentLvl.equals("### Лисенок")) {
            nextLvl = "### Вернуться домой";
        }
        if (currentLvl.equals("### Отправиться на поиски")) {
            nextLvl="### Попытаться разузнать о Бельчонке у лесных жителей";
        }
        if (currentLvl.equals("### Попытаться разузнать о Бельчонке у лесных жителей")) {
            nextLvl="### Расспросить Сову";
        }
        if (currentLvl.equals("### Скорее отнести мёд Медвежонку")) {
            nextLvl="### Искать Бельчонка в одиночку";
        }
        if (currentLvl.equals("### Попытаться разузнать о Бельчонке у лесных жителей")) {
            nextLvl="### Расспросить Сову";
        }
        if (currentLvl.equals("### Расспросить Волка")) {
            nextLvl="### Вернуться домой";
        }
        if (currentLvl.equals("### Расспросить Сову")) {
            nextLvl= "### Поверить Сове и отправиться вглубь леса";
        }
        if (currentLvl.equals("### Поверить Сове и отправиться вглубь леса")) {
            nextLvl= "### Искать Бельчонка в одиночку";
        }
        if (currentLvl.equals("### Нужно воспользоваться шансом и раздобыть мёд")) {
            nextLvl= "### Подождать, вдруг пчёлы улетят";
        }
        if (currentLvl.equals("### Подождать, вдруг пчёлы улетят")) {
            nextLvl= "### Поесть немного и передохнуть";
        }
        story(nextLvl);
    }
    private void switcher2(){
        String nextLvl="";
        if (currentLvl.equals("### Лисенок")) {
            nextLvl="### Отправиться на поиски";
        }
        if (currentLvl.equals("### Отправиться на поиски")) {
            nextLvl="### Искать Бельчонка в одиночку";
        }
        if (currentLvl.equals("### Скорее отнести мёд Медвежонку")) {
            nextLvl="### Вернуться домой";
        }
        if (currentLvl.equals("### Попытаться разузнать о Бельчонке у лесных жителей")) {
            nextLvl="### Расспросить Волка";
        }
        if (currentLvl.equals("### Расспросить Волка")) {
            nextLvl="### Искать Бельчонка в одиночку";
        }
        if (currentLvl.equals("### Расспросить Сову")) {
            nextLvl="### Искать Бельчонка в одиночку";
        }
        if (currentLvl.equals("### Поверить Сове и отправиться вглубь леса")) {
            nextLvl= "### Нужно воспользоваться шансом и раздобыть мёд";
        }
        if (currentLvl.equals("### Нужно воспользоваться шансом и раздобыть мёд")) {
            nextLvl= "### Нужно попытаться выкрасть мёд немедленно";
        }
        if (currentLvl.equals("### Подождать, вдруг пчёлы улетят")) {
            nextLvl= "### Скорее отнести мёд Медвежонку";
        }

        story(nextLvl);
    }

}
