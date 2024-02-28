package nuk.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileWriter {
    public static Optional<Path> writeToFile(String data, String pathToFile, String fileName, OpenOption... openOptions) {
        Path path = Paths.get(pathToFile + "/" + fileName);

        if (!FileManager.doesDirectoryToFileExist(path)) return Optional.empty();
        if (!FileManager.doesFileExist(path)) return Optional.empty();

        byte[] dataBytes = data.getBytes();

        try {
            Files.write(path, dataBytes, openOptions);
            return Optional.of(path);
        } catch (IOException e) {
            System.out.println("Failed to write to file.");
            return Optional.empty();
        }
    }

    public static Optional<Path> createAndWriteToFile(String data, String pathToFile, String fileName, OpenOption... openOptions) {
        Path path = Paths.get(pathToFile + "/" + fileName);
        Path dir = Paths.get(pathToFile);

        if (!FileManager.doesDirectoryToFileExist(path)) {
            FileManager.createDirectoryRecursively(dir);
        }

        if (!FileManager.doesFileExist(path)) {
            FileManager.createFile(path);
        }

        byte[] dataBytes = data.getBytes();

        try {
            Files.write(path, dataBytes, openOptions);
            return Optional.of(path);
        } catch (IOException e) {
            System.out.println("Failed to write to file.");
            return Optional.empty();
        }
    }

}
