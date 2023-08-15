package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            String timeLog = null;
            for (String str = reader.readLine(); str != null; str = reader.readLine()) {
                if (str.startsWith("400") || str.startsWith("500")) {
                    if (timeLog == null) {
                        timeLog = str.substring(4);
                    }
                } else if (timeLog != null) {
                    writer.printf("%s;%s%n", timeLog, str.substring(4));
                    timeLog = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("./data/server.log", "./data/target.csv");
    }
}
