package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    public static final String MENU = """
                Введите 1, чтобы загрузить содержимое файла в кэш.
                Введите 2, чтобы получить содержимое файла из кэша.
                Введите любое другое число для выхода.
            """;
    public static final String DIRECTORY = "Укажите директорию.";
    public static final String FILE = "Введите имя файла.";
    public static final int ADD = 1;
    public static final int GET = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            int select = Integer.parseInt(scanner.nextLine());
            System.out.println(select);
            if (ADD == select) {
                System.out.println(DIRECTORY);
                String path = scanner.nextLine();
                System.out.println(FILE);
                String file = scanner.nextLine();
                new DirFileCache(path).get(file);
            } else if (GET == select) {
                System.out.println(DIRECTORY);
                String path = scanner.nextLine();
                System.out.println(FILE);
                String file = scanner.nextLine();
                System.out.println(new DirFileCache(path).get(file));
            } else {
                run = false;
                System.out.println("Конец работы.");
            }
        }
    }
}
