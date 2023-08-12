package ru.job4j.io;

import java.io.*;
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

    public void saveTo(List<String> log, String file) {
        try (PrintWriter bufferedWriter = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            log.forEach(bufferedWriter::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> list = logFilter.filter("data/log.txt");
        logFilter.saveTo(list, "data/404.txt");
        list.forEach(System.out::println);
    }
}