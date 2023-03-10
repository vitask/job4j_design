package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCollectionTest {

    @Test
    void generalAssert() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).isNotNull()
                .hasSize(5)
                .contains(1, 3, 5)
                .containsOnly(1, 5, 4, 3)
                .containsExactly(1, 1, 3, 4, 5)
                .startsWith(1, 1)
                .endsWith(4, 5)
                .containsSequence(3, 4, 5);
    }

    @Test
    void satisfyAsser() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).isNotNull()
                .allSatisfy(i -> {
                    assertThat(i).isLessThan(10);
                    assertThat(i).isGreaterThan(0);
                })
                .anySatisfy(i -> {
                    assertThat(i).isEqualTo(3);
                    assertThat(i).isGreaterThan(1);
                })
                .allMatch(i -> i < 10)
                .allMatch(i -> i >= 1)
                .anyMatch(i -> i == 5);
    }

    @Test
    void checkNavigationList() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).first()
                .isNotNull()
                .isEqualTo(1);
        assertThat(sc).element(0).isEqualTo(1);
    }

    @Test
    void checkFilteredList() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).filteredOn(i -> i > 1)
                .first()
                .isEqualTo(3);
        assertThat(sc).filteredOnAssertions(i -> assertThat(i).isLessThan(3))
                .hasSize(2)
                .first()
                .isEqualTo(1);
    }

    @Test
    void assertMap() {
        Map<Integer, String> map = Map.of(1, "1", 2, "2", 3, "3");
        assertThat(map).hasSize(3)
                .containsKeys(1, 3, 2)
                .containsValues("2", "3", "1")
                .doesNotContainKeys(4, 7, 9)
                .containsEntry(2, "2");
    }
}