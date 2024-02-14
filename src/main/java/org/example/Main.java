package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру БЫКИ-КОРОВЫ" + '\n' +
                "Для того чтобы продолжить выберете действие: " + '\n' +
                "1. Правила игры \n" +
                "2. Начать игру с числами; \n" +
                "3. Начать игру с русскими буквами; \n" +
                "4. Начать игру с английскими буквами; \n" +
                "5. Закончить игру");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
            case 2:
                AbstractGame nGame = new NumberGame();
                nGame.start(4, 13);
                Scanner numSc = new Scanner(System.in);
                while (nGame.getGameStatus().equals(GameStatus.START)) {
                    System.out.println("Ваш ход");
                    String value = numSc.nextLine();
                    Answer answer = nGame.inputValue(value);
                    System.out.println(answer);
                }
                System.out.println(nGame.getGameStatus().getDescription());
                break;
            case 3:
                AbstractGame ruGame = new RuGame();
                ruGame.start(4, 13);
                Scanner ruSc = new Scanner(System.in);
                while (ruGame.getGameStatus().equals(GameStatus.START)) {
                    System.out.println("Ваш ход");
                    String value = ruSc.nextLine();
                    Answer answer = ruGame.inputValue(value);
                    System.out.println(answer);
                }
                System.out.println(ruGame.getGameStatus().getDescription());
                break;
            case 4:
                AbstractGame enGame = new RuGame();
                enGame.start(4, 13);
                Scanner enSc = new Scanner(System.in);
                while (enGame.getGameStatus().equals(GameStatus.START)) {
                    System.out.println("Ваш ход");
                    String value = enSc.nextLine();
                    Answer answer = enGame.inputValue(value);
                    System.out.println(answer);
                }
                System.out.println(enGame.getGameStatus().getDescription());
                break;

        }

    }
}