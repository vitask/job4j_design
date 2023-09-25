package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        String delimiter = argsName.get("delimiter");
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(argsName.get("path")))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> header = List.of(list.get(0).split(delimiter));
        List<Integer> index = Arrays.stream(argsName.get("filter")
                        .split(","))
                .map(header::indexOf)
                .toList();
        StringBuilder sb = new StringBuilder();
        for (String value : list) {
            String[] lines = value.split(delimiter);
            sb.append(index.stream()
                            .map(s -> lines[s])
                            .collect(Collectors.joining(delimiter)))
                    .append(System.lineSeparator());
        }
        if ("stdout".equals(argsName.get("out"))) {
            System.out.println(sb);
        } else {
            try (PrintWriter printWriter = new PrintWriter(argsName.get("out"))) {
                printWriter.print(sb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void validate(ArgsName argsName) {
        if (!argsName.get("path").endsWith(".csv")) {
            throw new IllegalArgumentException(String.format(
                    "File %s is not correct", argsName.get("path")
            ));
        }
        if (!";".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException(
                    "Delimiter is not equals \";\""
            );
        }
        if (!"stdout".equals(argsName.get("out"))) {
            throw new IllegalArgumentException(
                    "The value of \"out\" is not equal to \"stdout\" or the file path"
            );
        }
        if (argsName.get("filter").length() < 1) {
            throw new IllegalArgumentException(
                    "The value of filter is not correct"
            );
        }
    }

    public static void main(String[] args) throws Exception {
        CSVReader csvReader = new CSVReader();
        ArgsName argsName = ArgsName.of(args);
        csvReader.validate(argsName);
        handle(argsName);
    }
}
