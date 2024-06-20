package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void when16Then16() {
        assertThat(Fool.answer(16)).isEqualTo("16");
    }

    @Test
    void when15ThenFizzBuzz() {
        assertThat(Fool.answer(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void when21ThenFizz() {
        assertThat(Fool.answer(21)).isEqualTo("Fizz");
    }

    @Test
    void when20ThenBuzz() {
        assertThat(Fool.answer(20)).isEqualTo("Buzz");
    }
}