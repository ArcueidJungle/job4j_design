package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkToList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("five", "second", "first", "three", "four");
        assertThat(list).hasSize(5)
                .allMatch(e -> e.length() < 7)
                .anyMatch(e -> e.equals("second"))
                .containsSequence("second", "first")
                .doesNotContain("six")
                .first().isNotNull()
                .isEqualTo("five");
    }

    @Test
    void checkToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("five", "second", "first", "three",
                "four", "five", "second", "first", "three", "four");
        assertThat(set).filteredOnAssertions(e -> assertThat(e.length()).isGreaterThan(4))
                .hasSize(3)
                .noneMatch(e -> e.equals("five"));
    }

    @Test
    void checkToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("five" , "second", "first", "three", "four");
        assertThat(map).hasSize(5)
                .containsValues(0, 1, 2, 4)
                .containsKeys("five", "second");
    }
}