package nuk.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Optional;

public class FileWriter {

    /**
     * Writes data to a file if it exists as well as the directory.
     *
     * @param data
     *         the data to write to the file
     * @param pathToFile
     *         the path to the file to write to
     * @param openOptions
     *         options specifying how the data is written
     *
     * @return the path to the file if successful, otherwise an empty optional
     */
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

    /**
     * Creates a file and writes data to it. If the file doesn't exist, it will be created. If the directory doesn't exist, it will be recursively created as well.
     *
     * @param data
     *         the data to write to the file
     * @param pathToFile
     *         the path to the file to write to
     * @param openOptions
     *         options specifying how the data is written
     *
     * @return the path to the file if successful, otherwise an empty optional
     */
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
