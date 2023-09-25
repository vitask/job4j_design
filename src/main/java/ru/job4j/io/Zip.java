package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getName()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validate(ArgsName argsName) {
        File file = new File(argsName.get("d"));
        if (!Files.isDirectory(file.toPath()) && !Files.exists(file.toPath())) {
            throw new IllegalArgumentException("The root folder does not exist");
        }
        if (!argsName.get("e").startsWith(".")) {
            throw new IllegalArgumentException("The file extension must start with a point");
        }
        if (!argsName.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("The argument should ends with .zip");
        }
    }

        public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        String directory = argsName.get("d");
        String exclude = argsName.get("e");
        String output = argsName.get("o");

        validate(argsName);
        List<Path> pathList = Search.search(Path.of(directory),
                path -> !path.toFile().getName().endsWith(exclude));

        Zip zipFiles = new Zip();
        zipFiles.packFiles(pathList, new File(output));
    }
}
