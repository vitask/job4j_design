package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert sc = new SimpleConvert();
        String[] array = sc.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .containsAnyOf("three", "odin", "zero")
                .contains("five", Index.atIndex(4))
                .doesNotContain("six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert sc = new SimpleConvert();
        List<String> list = sc.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .isNotNull()
                .containsOnly("first", "second", "four", "three", "five")
                .containsAnyOf("give", "gift", "five")
                .first().isEqualTo("first");
    }

    @Test
    void checkSet() {
        SimpleConvert sc = new SimpleConvert();
        Set<String> set = sc.toSet("one", "two", "three");
        assertThat(set).isNotNull()
                .hasSize(3)
                .allSatisfy(i -> {
                    assertThat(i).isNotEmpty();
                    assertThat(i).isLowerCase();
                        })
                .filteredOn(s -> s.length() > 4)
                .filteredOnAssertions(s -> assertThat(s).isEqualTo("three"))
                .isNotEqualTo("one")
                .hasSize(1);
    }

    @Test
    void checkMap() {
        SimpleConvert sc = new SimpleConvert();
        Map<String, Integer> map = sc.toMap("one", "two", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKey("two")
                .doesNotContainKeys("2")
                .containsValues(2, 3)
                .doesNotContainValue(12)
                .containsEntry("one", 0);
    }
}