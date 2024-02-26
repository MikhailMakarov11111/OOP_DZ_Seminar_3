package org.example.controller;

import org.example.model.*;
import org.example.view.ViewGame;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Controller implements Gameplay {
    static Scanner scanner = new Scanner(System.in);
    static ViewGame viewGame = new ViewGame();
    static AbstractGame abstractGame;

    public static void main(String[] args) {
        boolean res = true;
        while (res) {
            int welcom = viewGame.welcomeScreen(scanner);
            switch (welcom) {
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
                    abstractGame = new NumberGame();
                    res = false;
                    break;
                case 3:
                    abstractGame = new RuGame();
                    res = false;
                    break;
                case 4:
                    abstractGame = new EnGame();
                    res = false;
                    break;
                case 5:
                    viewGame.endScreen();
                    res = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение \n" +
                            "Пожалуйста повторите попытку ");
                    break;
            }
        }


    }
    @Override
    public void gamePlay() {
        abstractGame.start(4, 10);
        while (abstractGame.getGameStatus().equals(GameStatus.START)) {
            String inputPlayer = viewGame.inputPlayer(scanner);
            viewGame.inputAnswer(abstractGame.inputValue(inputPlayer));
        }
        if (abstractGame.getGameStatus().equals(GameStatus.WIN)) {
            viewGame.playerWin();
        } else if (abstractGame.getGameStatus().equals(GameStatus.END)) {
            viewGame.playerEnd(abstractGame.getWord());
        }
        if (viewGame.viewingHistory(scanner)){
            HistoryGame historyGame = abstractGame.getHistoryGame();
            viewGame.historyGamePlayer(abstractGame.getHistoryGame());
        }
        else {
            viewGame.endScreen();
        }
    }
}
