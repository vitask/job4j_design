package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(nl::getMap)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkLength() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(nl::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("empty");
    }

    @Test
    void checkSymbol() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("key:value"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: key:value does not contain the symbol \\=");
    }

    @Test
    void checkKey() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("=name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: =name does not contain a key");
    }

    @Test
    void checkValue() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("key="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("this name: key= does not contain a value");
    }

}