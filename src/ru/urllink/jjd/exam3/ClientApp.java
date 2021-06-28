package ru.urllink.jjd.exam3;


public class ClientApp {
    public static void main(String[] args) {

        new Client("localhost", 5657).start();
    }
}
