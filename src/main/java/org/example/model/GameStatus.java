package org.example.model;

public enum GameStatus {
    INIT, START, END ("К сожалению Вы проиграли"), WIN ("Поздравляю Вы выйграли");

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