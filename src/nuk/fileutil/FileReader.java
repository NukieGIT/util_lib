package nuk.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readAllLines(Path pathToFile) {
        try {
            return Files.readAllLines(pathToFile);
        } catch (IOException e) {
            System.out.println("Failed to read file.");
            return List.of();
        }
    }

    public static Scanner getScanner(Path pathToFile) throws IOException {
        var bw = Files.newBufferedReader(pathToFile);
        return new Scanner(bw);
    }
}
