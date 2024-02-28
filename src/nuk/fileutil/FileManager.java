package nuk.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileManager {
    public static boolean doesFileExist(String pathToFile) {
        Path path = Paths.get(pathToFile);
        return Files.exists(path);
    }

    public static boolean doesFileExist(Path pathToFile) {
        return Files.exists(pathToFile);
    }

    public static boolean doesDirectoryToFileExist(String pathToFile) {
        Path pathParent = Paths.get(pathToFile).getParent();
        return pathParent != null && Files.isDirectory(pathParent);
    }

    public static boolean doesDirectoryToFileExist(Path pathToFile) {
        Path pathParent = pathToFile.getParent();
        return pathParent != null && Files.isDirectory(pathParent);
    }

    public static boolean doesDirectoryExist(String pathToDir) {
        Path path = Paths.get(pathToDir);
        return Files.isDirectory(path);
    }

    public static boolean doesDirectoryExist(Path pathToDir) {
        return pathToDir != null && Files.isDirectory(pathToDir);
    }

    public static Optional<Path> createFile(String pathToFile, String fileName) {
        Path path = Paths.get(pathToFile + "/" + fileName);

        if (!doesDirectoryToFileExist(path)) return Optional.empty();
        if (doesFileExist(path)) return Optional.empty();

        try {
            Files.createFile(path);
        } catch (IOException e) {
            System.out.println("File not created");
            return Optional.empty();
        }

        return Optional.of(path);
    }

    public static Optional<Path> createFile(Path pathToFile) {
        if (!doesDirectoryToFileExist(pathToFile)) return Optional.empty();
        if (doesFileExist(pathToFile)) return Optional.empty();

        try {
            Files.createFile(pathToFile);
        } catch (IOException e) {
            System.out.println("File not created");
            return Optional.empty();
        }

        return Optional.of(pathToFile);
    }

    public static boolean deleteFile(String pathToFile, String fileName) {
        Path path = Paths.get(pathToFile + "/" + fileName);

        try {
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            System.out.println("File deletion failed, probably tried deleting a directory.");
            return false;
        }
    }

    public static boolean deleteFile(Path pathToFile) {
        try {
            return Files.deleteIfExists(pathToFile);
        } catch (IOException e) {
            System.out.println("File deletion failed, probably tried deleting a directory.");
            return false;
        }
    }

    public static boolean createDirectoryRecursively(String pathToDir) {
        Path path = Paths.get(pathToDir);

        if (doesDirectoryExist(path)) return true;

        try {
            Files.createDirectories(path);
            return true;
        } catch (IOException e) {
            System.out.println("Failed to create directories.");
            return false;
        }
    }

    public static boolean createDirectoryRecursively(Path pathToDir) {
        if (doesDirectoryExist(pathToDir)) return true;

        try {
            Files.createDirectories(pathToDir);
            return true;
        } catch (IOException e) {
            System.out.println("Failed to create directories.");
            return false;
        }
    }
}
