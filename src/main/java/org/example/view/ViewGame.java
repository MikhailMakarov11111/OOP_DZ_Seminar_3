package org.example.view;

import org.example.model.Answer;
import org.example.model.GameStatus;
import org.example.model.HistoryGame;

import java.util.Scanner;

public class ViewGame {
    public static int welcomeScreen(Scanner scanner) {
        System.out.println("Добро пожаловать в игру БЫКИ-КОРОВЫ");
        System.out.println("Для того чтобы продолжить выберете действие: " + '\n' +
                "1. Правила игры \n" +
                "2. Начать игру с числами; \n" +
                "3. Начать игру с русскими буквами; \n" +
                "4. Начать игру с английскими буквами; \n" +
                "5. Закончить игру");
        return scanner.nextInt();
    }

    public static void endScreen() {
        System.out.println("Спасибо что играли в нашу  игру. До новых встреч!");
    }

    public static void inputAnswer(Answer answer) {
        System.out.println(answer);
    }

//    public static String playerInput(Scanner scanner) {
//        System.out.print("Выберите пожалуйста действие ");
//        return scanner.next().toLowerCase();
//    }

    public static void playerWin() {
        GameStatus win = GameStatus.WIN;
    }

    public static void playerEnd(String word) {
        GameStatus end = GameStatus.END;
        System.out.println("Загаданное слово - " + word);
    }

    public static boolean viewingHistory(Scanner scanner) {
        System.out.println("Желаете посмотреть историю своей игры? (да или нет)");
        String result = scanner.next();
        return result.equalsIgnoreCase("да");
    }

    public static void historyGamePlayer(HistoryGame historyGame) {
        System.out.println("История Ваших действий в игре: ");
        for (String playerAction : historyGame.getHistoryActions()) {
            System.out.println(playerAction);
        }
    }
    public static String inputPlayer(Scanner scanner) {
        System.out.println("Введите Ваш вариант: ");
        return scanner.next().toLowerCase();
    }

}
