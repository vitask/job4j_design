package ru.job4j.assertj;

public class SimpleModel {
    private String name = "";

    public String getName() {
        if (name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    public void setName(String word, int number) {
            if (name.length() != number) {
                throw new IllegalArgumentException(
                        String.format("This word: %s has length not equal to :%s", word, number)
                );
            }
            this.name = word;
    }
}
