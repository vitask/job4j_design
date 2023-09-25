package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean play = true;
        List<String> log = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String console = scanner.nextLine();
        List<String> phrases = readPhrases();

        while (!OUT.equals(console)) {
            log.add(console);
            if (STOP.equals(console)) {
                play = false;
            } else if (CONTINUE.equals(console)) {
                play = true;
            } else if (play) {
                String answer = phrases.get(new Random().nextInt(phrases.size()));
                System.out.println(answer);
                log.add(answer);
            }
            console = scanner.nextLine();
        }
        log.add(console);
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> listPhrases = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            listPhrases = reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listPhrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/logDialog.txt", "./data/answer.txt");
        cc.run();
    }
}
