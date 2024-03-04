package com.nuk.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileManager {

    /**
     * Checks if a file exists at the given path.
     *
     * @param pathToFile
     *         the path to the file
     *
     * @return true if the file exists, false otherwise
     */
    public static boolean doesFileExist(String pathToFile) {
        Path path = Paths.get(pathToFile);
        return Files.exists(path);
    }

    /**
     * Checks if a file exists at the given path.
     *
     * @param pathToFile
     *         the path to the file
     *
     * @return true if the file exists, false otherwise
     */
    public static boolean doesFileExist(Path pathToFile) {
        return Files.exists(pathToFile);
    }

    /**
     * Checks if the directory to the given file exists.
     *
     * @param pathToFile
     *         the path to the file
     *
     * @return true if the directory exists, false otherwise
     */
    public static boolean doesDirectoryToFileExist(String pathToFile) {
        Path pathParent = Paths.get(pathToFile).toAbsolutePath().getParent();
        return pathParent != null && Files.isDirectory(pathParent);
    }

    /**
     * Checks if the directory to the given file exists.
     *
     * @param pathToFile
     *         the path to the file
     *
     * @return true if the directory exists, false otherwise
     */
    public static boolean doesDirectoryToFileExist(Path pathToFile) {
        Path pathParent = pathToFile.toAbsolutePath().getParent();
        return pathParent != null && Files.isDirectory(pathParent);
    }

    /**
     * Checks if the element at the given path is a directory.
     *
     * @param pathToDir
     *         the path to the directory
     *
     * @return true if the element is a directory, false otherwise
     */
    public static boolean doesDirectoryExist(String pathToDir) {
        Path path = Paths.get(pathToDir);
        return Files.isDirectory(path);
    }

    /**
     * Checks if the element at the given path is a directory.
     *
     * @param pathToDir
     *         the path to the directory
     *
     * @return true if the element is a directory, false otherwise
     */
    public static boolean doesDirectoryExist(Path pathToDir) {
        return pathToDir != null && Files.isDirectory(pathToDir);
    }

    /**
     * Creates a file at the given path. If the file already exists or the directory doesn't, it will not be created.
     *
     * @param pathToFile
     *         path to create the file at
     * @param fileName
     *         name of the file
     *
     * @return optional containing the path to the file if it was created, empty otherwise
     */
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

    /**
     * Creates a file at the given path. If the file already exists or the directory doesn't, it will not be created.
     *
     * @param pathToFile
     *         path to create the file at
     *
     * @return optional containing the path to the file if it was created, empty otherwise
     */
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

    /**
     * Deletes a file at the given path.
     *
     * @param pathToFile
     *         path to the file
     * @param fileName
     *         name of the file
     *
     * @return true if the file was deleted, false otherwise
     */
    public static boolean deleteFile(String pathToFile, String fileName) {
        Path path = Paths.get(pathToFile + "/" + fileName);

        try {
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            System.out.println("File deletion failed, probably tried deleting a directory.");
            return false;
        }
    }

    /**
     * Deletes a file at the given path.
     *
     * @param pathToFile
     *         path to the file
     *
     * @return true if the file was deleted, false otherwise
     */
    public static boolean deleteFile(Path pathToFile) {
        try {
            return Files.deleteIfExists(pathToFile);
        } catch (IOException e) {
            System.out.println("File deletion failed, probably tried deleting a directory.");
            return false;
        }
    }

    /**
     * Creates a directory with the given path. If the directory already exists, it will not be created as well as return false.
     *
     * @param pathToDir
     *         directory path
     *
     * @return true if the directory was created, false otherwise
     */
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

    /**
     * Creates a directory with the given path. If the directory already exists, it will not be created as well as return false.
     *
     * @param pathToDir
     *         directory path
     *
     * @return true if the directory was created, false otherwise
     */
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
