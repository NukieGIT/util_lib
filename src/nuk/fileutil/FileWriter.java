package nuk.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Optional;

public class FileWriter {

        if (!FileManager.doesDirectoryToFileExist(path)) return Optional.empty();
        if (!FileManager.doesFileExist(path)) return Optional.empty();
    public static Optional<Path> writeToFile(String data, Path pathToFile, OpenOption... openOptions) {

        if (!FileManager.doesDirectoryToFileExist(pathToFile)) return Optional.empty();
        if (!FileManager.doesFileExist(pathToFile)) return Optional.empty();

        byte[] dataBytes = data.getBytes();

        try {
            Files.write(pathToFile, dataBytes, openOptions);
            return Optional.of(pathToFile);
        } catch (IOException e) {
            System.out.println("Failed to write to file.");
            return Optional.empty();
        }
    }

    public static Optional<Path> createAndWriteToFile(String data, String pathToFile, String fileName, OpenOption... openOptions) {
        Path path = Paths.get(pathToFile + "/" + fileName);
        Path dir = Paths.get(pathToFile);
    public static Optional<Path> createAndWriteToFile(String data, Path pathToFile, OpenOption... openOptions) {
        Path dir = pathToFile.getParent();

        if (dir != null && !FileManager.doesDirectoryToFileExist(pathToFile)) {
            FileManager.createDirectoryRecursively(dir);
        }

        if (!FileManager.doesFileExist(pathToFile)) {
            FileManager.createFile(pathToFile);
        }

        byte[] dataBytes = data.getBytes();

        try {
            Files.write(pathToFile, dataBytes, openOptions);
            return Optional.of(pathToFile);
        } catch (IOException e) {
            System.out.println("Failed to write to file.");
            return Optional.empty();
        }
    }

}
