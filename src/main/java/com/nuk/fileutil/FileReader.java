package com.nuk.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    /**
     * Reads all lines from a file and returns them as a list of strings.
     *
     * @param pathToFile
     *         the path to the file
     *
     * @return a list of strings, each representing a line from the file
     */
    public static List<String> readAllLines(Path pathToFile) {
        try {
            return Files.readAllLines(pathToFile);
        } catch (IOException e) {
            System.out.println("Failed to read file.");
            return List.of();
        }
    }

    /**
     * Opens a file for reading and returns a scanner to read text from the file.
     *
     * @param pathToFile
     *         the path to the file
     *
     * @return a scanner, to read text from the file
     * @throws IOException
     *         if an I/O error occurs opening the file
     */
    public static Scanner getScanner(Path pathToFile) throws IOException {
        var bw = Files.newBufferedReader(pathToFile);
        return new Scanner(bw);
    }
}
