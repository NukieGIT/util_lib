package nuk.userinput;

import java.io.Closeable;
import java.util.Scanner;

public class ConsoleReader implements Closeable {

    Scanner scanner;
    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public String getNextString() {
        return scanner.next();
    }

    public String getNextStringWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextString();
    }

    public String getNextLine() {
        return scanner.nextLine();
    }

    public String getNextLineWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextLine();
    }

    public int getNextInt() {
        return scanner.nextInt();
    }

    public int getNextIntWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextInt();
    }

    public double getNextDouble() {
        return scanner.nextDouble();
    }

    public double getNextDoubleWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextDouble();
    }

    public float getNextFloat() {
        return scanner.nextFloat();
    }

    public float getNextFloatWithLabel(String label) {
        System.out.printf("%s: ", label);
        return getNextFloat();
    }

    public QuestionGenerator getQuestionGenerator() {
        return new QuestionGenerator(this);
    }

    @Override
    public void close() {
        scanner.close();
    }
}
