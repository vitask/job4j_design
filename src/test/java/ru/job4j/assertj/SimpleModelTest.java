package ru.job4j.assertj;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleModelTest {

    @Test
    void checkGetName() {
        SimpleModel sm = new SimpleModel();
        assertThatThrownBy(sm::getName)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkSetName() {
        SimpleModel sm = new SimpleModel();
        assertThatThrownBy(() -> sm.setName("name", 4))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void checkMessage() {
        SimpleModel sm = new SimpleModel();
        String word = "name";
        int number = 4;
        assertThatThrownBy(() -> sm.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void checkWordMessage() {
        SimpleModel sm = new SimpleModel();
        String word = "name";
        int number = 4;
        assertThatThrownBy(() -> sm.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word, number)
                .hasMessageContaining("name");
    }
}