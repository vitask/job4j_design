package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ModelTest {

    @Test
    void checkBoolean() {
        Model model = new Model(1, 5.252d, "Name", true);
        boolean rsl = model.isCondition();
        assertThat(rsl).isTrue();
    }

    @Test
    void checkStringChain() {
        Model model = new Model(2, 3.45d, "I am learning Java", true);
        String rsl = model.getLine();
        assertThat(rsl).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("java")
                .contains("am", "Java")
                .doesNotContain("JavaScript")
                .startsWith("I am")
                .startsWithIgnoringCase("i")
                .endsWith("Java")
                .isEqualTo("I am learning Java");
    }

    @Test
    void checkInt() {
        Model model = new Model(4, 5.2d, "name", true);
        int rsl = model.getTop();
        assertThat(rsl).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(1)
                .isLessThan(5)
                .isEqualTo(4);
    }

    @Test
    void checkDoubleChain() {
        Model model = new Model(1, 5.255d, "name", true);
        double result = model.getNum();
        assertThat(result).isEqualTo(5.26d, withPrecision(0.006d))
                .isCloseTo(5.25d, withPrecision(0.01d))
                .isCloseTo(5.25d, Percentage.withPercentage(1.0d))
                .isGreaterThan(5.25d)
                .isLessThan(5.26d);
    }
}