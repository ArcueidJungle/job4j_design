package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AnalysisTest {

    @Test
    void drop(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("400 10:56:06");
            out.println("500 10:57:07");
            out.println("200 10:58:08");
        }
        File target = tempDir.resolve("target.txt").toFile();
        Analysis one = new Analysis();
        one.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(result :: append);
        }
        assertThat("10:56:06;10:58:08;").hasToString(result.toString());
    }
}
