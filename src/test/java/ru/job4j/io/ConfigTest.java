package ru.job4j.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenExampleWithCommentEmptyData() {
        String path = "./data/example.properties";
        Config config = new Config(path);
        assertThatThrownBy(config :: load)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenExampleWithoutComment() {
        String path = "./data/secondExample.properties";
        Config config = new Config(path);
        assertThatThrownBy(config :: load)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenSecondExampleWithoutComment() {
        String path = "./data/secondExample.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isNull();
    }
}