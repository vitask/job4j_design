package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;

class AnalysisTest {

    @Test
    void unavailableTest(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01\n"
                    + "200 10:57:01\n"
                    + "400 10:58:01\n"
                    + "200 10:59:01\n"
                    + "500 11:01:02\n"
                    + "200 11:02:02");
        }

        File target = tempDir.resolve("target.txt").toFile();
        Analysis test = new Analysis();
        test.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(sb -> rsl.append(sb).append(System.lineSeparator()));
        }
        assertThat(String.format("%s%n%s%n", "10:58:01;10:59:01", "11:01:02;11:02:02"))
                .isEqualTo(rsl.toString());
    }
}