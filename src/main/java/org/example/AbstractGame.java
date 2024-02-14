package org.example;

import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    private String word;
    private GameStatus status = GameStatus.INIT;
    private Integer maxTry;

    public String generateWord(Integer size) {
        StringBuilder word = new StringBuilder();
        List<String> charList = generateCharList();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            word.append(charList.get(random.nextInt(charList.size())));
        }
        return word.toString();
    }

    public abstract List<String> generateCharList();

    @Override
    public void start(Integer sizeWorld, Integer maxTry) {
        this.word = generateWord(sizeWorld);
        status = GameStatus.START;
        this.maxTry = maxTry;
    }

    @Override
    public Answer inputValue(String value) {
        if (!getGameStatus().equals(GameStatus.START)) {
            throw new RuntimeException("Игра не в активном состоянии");
        }
        Integer countCow = 0;
        Integer countBull = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == value.charAt(i)) {
                countBull++;
            }
            if (word.contains(String.valueOf(value.charAt(i)))) {
                countCow++;
            }
        }

        --maxTry;

        if (countBull == word.length()) {
            status = GameStatus.WIN;
        } else if (maxTry == 0) {
            status = GameStatus.END;
        }

        return new Answer(maxTry, countBull, countCow);
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }
}
