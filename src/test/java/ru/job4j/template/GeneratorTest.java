package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {

    @Test
    public void whenGetGenerator() {
        var generator = new GeneratorText();
        var template = "I am a ${name}, Who are ${subject}? ";
        var args = Map.of("name", "Vitaly",
                "subject", "you");
        var expected = "I am a Vitaly, Who are you? ";
        var result = generator.produce(template, args);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNotFoundArgsGetException() {
        var generator = new GeneratorText();
        var template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenNotFoundKeyGetException() {
        var generator = new GeneratorText();
        var template = "I am a ${NAME}, Who are ${subject}? ";
        var args = Map.of("name", "Vitaly",
                "subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenValueIsNullGetException() {
        var generator = new GeneratorText();
        var template = "I am a ${name}, Who are ${subject}? ";
        var args = Map.of("name", null,
                "subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenMoreKeyGetException() {
        var generator = new GeneratorText();
        var template = "I am a ${name}, Who are ${subject}? ";
        var args = Map.of("name", "Vitalya",
                "subject", "you",
                "surname", "Skalenko");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}