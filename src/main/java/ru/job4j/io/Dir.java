package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("/Users/vitalijskalenko");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("size : %s%n", file.getTotalSpace());
        for (File subFile : file.listFiles()) {
            if (subFile.isFile()) {
                System.out.printf("File Name - %s : File Size - %d\n", subFile.getName(), subFile.length());
            }
        }
    }
}