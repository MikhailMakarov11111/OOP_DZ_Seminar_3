package org.example;

public class Answer {
    private Integer countTry;
    private Integer countBull;
    private Integer countCow;

    public Answer(Integer countTry, Integer countBull, Integer countCow) {
        this.countTry = countTry;
        this.countBull = countBull;
        this.countCow = countCow;
    }

    @Override
    public String toString() {
        return "Вывод " +
                "Осталось попыток = " + countTry +
                ", Быков = " + countBull +
                ", Коров = " + countCow;
    }
}
