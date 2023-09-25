package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format(
                    "This key: '%s' is missing", key
            ));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String str : args) {
            String[] key = ArgsName.check(str);
            values.put(key[0].substring(1), key[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName argsName = new ArgsName();
        argsName.parse(args);
        return argsName;
    }

    private static String[] check(String arg) {
        String[] parts = arg.split("=", 2);
        if (!arg.startsWith("-")) {
            throw new IllegalArgumentException(String.format(
                    "Error: This argument '%s' does not start with a '-' character", arg
            ));
        }
        if (!arg.contains("=")) {
            throw new IllegalArgumentException(String.format(
                    "Error: This argument '%s' does not contain an equal sign", arg
            ));
        }
        if (arg.endsWith("=") && parts[1].isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "Error: This argument '%s' does not contain a value", arg
            ));
        }
        if (arg.startsWith("-=")) {
            throw new IllegalArgumentException(String.format(
                    "Error: This argument '%s' does not contain a key", arg
            ));
        }
        return parts;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}