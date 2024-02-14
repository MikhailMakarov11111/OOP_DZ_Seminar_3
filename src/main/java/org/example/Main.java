package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AbstractGame nGame = new EnGame();

        nGame.start(4, 2);
        Scanner scanner = new Scanner(System.in);

        while (nGame.getGameStatus().equals(GameStatus.START)) {
            System.out.println("Ваш ход");
            String value = scanner.nextLine();
            Answer answer = nGame.inputValue(value);
            System.out.println(answer);
        }
        System.out.println(nGame.getGameStatus().getDescription());
    }
}