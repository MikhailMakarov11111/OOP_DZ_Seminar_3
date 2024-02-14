package org.example;

public enum GameStatus {
    INIT, START, END ("Вы проиграли"), WIN ("Вы выйграли");

    private String description;

    GameStatus(String description) {
        this.description = description;
    }

    GameStatus() {
    }

    public String getDescription() {
        return description;
    }
}