package org.example.view;

import org.example.model.*;

import java.util.Scanner;

public class View {
    public static void welcomeScreen() {
        System.out.println("Добро пожаловать в игру БЫКИ-КОРОВЫ");
        System.out.println("Для того чтобы продолжить выберете действие: " + '\n' +
                "1. Правила игры \n" +
                "2. Начать игру с числами; \n" +
                "3. Начать игру с русскими буквами; \n" +
                "4. Начать игру с английскими буквами; \n" +
                "5. Закончить игру");
    }

    public static void inputAnswer(Answer answer) {
        System.out.println(answer);
    }

    public static String playerInput(Scanner scanner) {
        System.out.print("Выберите пожалуйста действие ");
        return scanner.next().toLowerCase();
    }

    public static void playerWin() {
        GameStatus win = GameStatus.WIN;
    }

    public static void playerEnd(String word) {
        GameStatus end = GameStatus.END;
        System.out.println("Загаданное слово - " + word);
    }

    public static boolean viewingHistory (Scanner scanner) {
        System.out.println("Желаете посмотреть историю своей игры? (да или нет)");
        String result = scanner.next();
        return result.equalsIgnoreCase("да");
    }
     public static void historyGamePlayer(HistoryGame historyGame) {
         System.out.println("История Ваших действий в игре: ");
         for (String playerAction : historyGame.getHistoryActions()){
             System.out.println(playerAction);
         }


     }


}
