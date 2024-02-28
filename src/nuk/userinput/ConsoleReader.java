package nuk.userinput;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
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

    public String getNextQuestion(IQuestion question) {
        var formattedAnswers = getFormattedAnswersWithDefault(question);
        System.out.printf("%s (%s)", question.getQuestion(), String.join("|", formattedAnswers));

        String usrRes = getNextString();
        if (question.isValidAnswer(usrRes)) {
            return usrRes;
        } else {
            System.out.println("Invalid response. Please try again.");
            return getNextQuestion(question);
        }
    }

    private List<String> getFormattedAnswersWithDefault(IQuestion question) {
        List<String> answers = question.getAnswers();
        List<String> defaultAnswers = question.getDefaultAnswers();
        List<String> formattedAnswers = new ArrayList<>();

        for (String answer : answers) {
            if (defaultAnswers.contains(answer)) {
                formattedAnswers.add(answer.toUpperCase());
            } else {
                formattedAnswers.add(answer.toLowerCase());
            }
        }

        return formattedAnswers;
    }

//    public boolean getNextQuestion(String question) {
//        System.out.printf("%s (y/n): ", question);
//        String response = getNextString();
//
//        if (response.equalsIgnoreCase("y")) {
//            return true;
//        } else if (response.equalsIgnoreCase("n")) {
//            return false;
//        } else {
//            System.out.println("Invalid response. Please enter 'y' or 'n'.");
//            return getNextQuestion(question);
//        }
//    }


    @Override
    public void close() {
        scanner.close();
    }
}
