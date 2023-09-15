package ru.job4j.io;



import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> map = new HashMap<>();

    public void getDuplicates() {
        for (Map.Entry<FileProperty, List<Path>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.printf("File name - \"%s\", size - %d byte%n",
                        entry.getKey().getName(), entry.getKey().getSize());
                System.out.println("Paths:");
                for (Path path : entry.getValue()) {
                    System.out.println(path.toAbsolutePath());
                }
            }
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        map.computeIfAbsent(fileProperty, k -> new ArrayList<>()).add(file);
        return super.visitFile(file, attrs);
    }
}
