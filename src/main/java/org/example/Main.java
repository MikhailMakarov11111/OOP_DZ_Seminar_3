package org.example;

import org.example.model.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру БЫКИ-КОРОВЫ");
        boolean res = true;
        while (res) {
            System.out.println("Для того чтобы продолжить выберете действие: " + '\n' +
                    "1. Правила игры \n" +
                    "2. Начать игру с числами; \n" +
                    "3. Начать игру с русскими буквами; \n" +
                    "4. Начать игру с английскими буквами; \n" +
                    "5. Закончить игру");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1:
                    try (FileReader reader = new FileReader("Rules.txt")) {
                        int c;
                        while ((c = reader.read()) != 1) {
                            System.out.println((char) c);
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    AbstractGame nGame = new NumberGame();
                    nGame.start(4, 13);
                    Scanner numSc = new Scanner(System.in);
                    while (nGame.getGameStatus().equals(GameStatus.START)) {
                        System.out.printf("Пожалуйста введите %s числа(ел)! \n", 4);
                        String value = numSc.nextLine();
                        Answer answer = nGame.inputValue(value);
                        System.out.println(answer);
                    }
                    System.out.println(nGame.getGameStatus().getDescription());
                    res = false;
                    break;
                case 3:
                    AbstractGame ruGame = new RuGame();
                    ruGame.start(4, 10);
                    Scanner ruSc = new Scanner(System.in);
                    while (ruGame.getGameStatus().equals(GameStatus.START)) {
                        System.out.printf("Пожалуйста введите %s русских букв! \n", 4);
                        String value = ruSc.nextLine();
                        Answer answer = ruGame.inputValue(value);
                        System.out.println(answer);
                    }
                    System.out.println(ruGame.getGameStatus().getDescription());
                    res = false;
                    break;
                case 4:
                    AbstractGame enGame = new EnGame();
                    enGame.start(4, 13);
                    Scanner enSc = new Scanner(System.in);
                    while (enGame.getGameStatus().equals(GameStatus.START)) {
                        System.out.printf("Пожалуйста введите %s английских букв! \n", 4);
                        String value = enSc.nextLine();
                        Answer answer = enGame.inputValue(value);
                        System.out.println(answer);
                    }
                    System.out.println(enGame.getGameStatus().getDescription());
                    res = false;
                    break;
                case 5:
                    System.out.println("Спасибо что играли в нашу  игру. До новых встреч!");
                    res = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение \n" +
                            "Пожалуйста повторите попытку ");
                    break;
            }
        }

    }

}
