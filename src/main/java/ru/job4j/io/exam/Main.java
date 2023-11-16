package ru.job4j.io.exam;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 4) {
            throw new IllegalArgumentException("Enter 4 argument");
        }

        ArgsName name = ArgsName.of(args);
        verification(name);
        Predicate<Path> condition = defineSearchType(name);
        List<Path> paths = Search.search(Path.of(name.get("d")), condition);
        outToFile(paths, name.get("o"));
    }

    private static void outToFile(List<Path> paths, String file) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            paths.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Path> defineSearchType(ArgsName argsName) {
        Predicate<Path> condition;
        String fileName = argsName.get("n");
        String fileType = argsName.get("t");
        switch (fileType) {
            case "name":
                condition = path -> path.toString().equals(fileName);
                break;
            case "regex":
                condition = path -> path.toString().matches(fileName);
                break;
            case "mask":
                String regex = fileName.replace(".", "\\.")
                        .replace("*", ".*")
                        .replace("?", ".?");
                condition = path -> path.toString().matches(regex);
                break;
            default:
                return null;
        }
        return condition;
    }

    private static void verification(ArgsName argsName) {
        Path directory = Path.of(argsName.get("d"));
        if (!Files.exists(directory) || !Files.isDirectory(directory)) {
            throw new IllegalArgumentException("This path is not exist");
        }
        if (!"\\w+\\.\\w+".matches(argsName.get("o"))) {
            throw new IllegalArgumentException("Error file name");
        }
        String search = argsName.get("t");
        if (!("name".equals(search) || "regex".equals(search) || "match".equals(search))) {
            throw new IllegalArgumentException("Enter 'name' or 'regex' or 'match'");
        }
        if (argsName.get("n").length() < 3) {
            throw new IllegalArgumentException("Invalid file name or mask or regex");
        }
    }

}
