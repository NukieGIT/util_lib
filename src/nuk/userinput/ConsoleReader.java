package nuk.userinput;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Scanner;

/**
 * A class to read user input from the console.
 * <p>
 * This class is a wrapper around the Scanner class to provide a more user-friendly interface for reading input from the console.
 * It implements the Closeable interface to allow for the Scanner to be closed when it is no longer needed using the try with resources statement.
 * </p>
 * {@snippet lang = java:
 *      try (ConsoleReader consoleReader = new ConsoleReader()) {
 *          // ...
 *      }
 *}
 */
public class ConsoleReader implements Closeable {

    private final Scanner scanner;

    /**
     * Create a new ConsoleReader, subsequently opening a {@link Scanner#Scanner(InputStream) scanner}.
     */
    public ConsoleReader(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    /**
     * Get the next string from the console.
     *
     * @return the string entered by the user
     */
    public String getNextString() {
        return scanner.next();
    }

    /**
     * Get the next string from the console with a pretty label.
     *
     * @param label
     *         the label to display before the user input
     *
     * @return the string entered by the user
     */
    public String getNextStringWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextString();
    }

    /**
     * Get the next line from the console.
     *
     * @return the line entered by the user
     */
    public String getNextLine() {
        return scanner.nextLine();
    }

    /**
     * Get the next line from the console with a pretty label.
     *
     * @param label
     *         the label to display before the user input
     *
     * @return the line entered by the user
     */
    public String getNextLineWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextLine();
    }

    /**
     * Get the next integer from the console.
     *
     * @return the integer entered by the user
     */
    public int getNextInt() {
        return scanner.nextInt();
    }

    /**
     * Get the next integer from the console with a pretty label.
     *
     * @param label
     *         the label to display before the user input
     *
     * @return the integer entered by the user
     */
    public int getNextIntWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextInt();
    }

    /**
     * Get the next double from the console.
     *
     * @return the double entered by the user
     */
    public double getNextDouble() {
        return scanner.nextDouble();
    }

    /**
     * Get the next double from the console with a pretty label.
     *
     * @param label
     *         the label to display before the user input
     *
     * @return the double entered by the user
     */
    public double getNextDoubleWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextDouble();
    }

    /**
     * Get the next float from the console.
     *
     * @return the float entered by the user
     */
    public float getNextFloat() {
        return scanner.nextFloat();
    }

    /**
     * Get the next float from the console with a pretty label.
     *
     * @param label
     *         the label to display before the user input
     *
     * @return the float entered by the user
     */
    public float getNextFloatWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextFloat();
    }

    /**
     * Create and get the {@link QuestionGenerator question generator}.
     *
     * @return the question generator
     */
    public QuestionGenerator getQuestionGenerator() {
        return new QuestionGenerator(this);
    }

    /**
     * Close the scanner.
     */
    @Override
    public void close() {
        scanner.close();
    }
}
