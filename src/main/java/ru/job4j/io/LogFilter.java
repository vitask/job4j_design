package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            list = reader.lines().map(log -> log.split(" "))
                    .filter(log -> "404".equals(log[log.length - 2]))
                    .map(log -> String.join(" ", log))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> list = logFilter.filter("data/log.txt");
        list.forEach(System.out::println);
    }
}
