package org.example;

public interface Game {
    void start(Integer sizeWorld, Integer maxTry);
    Answer inputValue(String value);
    GameStatus getGameStatus();
}
