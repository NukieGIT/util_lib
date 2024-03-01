package nuk.userinput;

import java.util.ArrayList;
import java.util.List;

public class QuestionGenerator {

    private final ConsoleReader consoleReader;

    QuestionGenerator(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public String askChoiceQuestion(IQuestion question) {
        var formattedAnswers = getFormattedAnswersWithDefault(question);
        System.out.printf("%s (%s): ", question.getQuestion(), String.join("|", formattedAnswers));

        var usrRes = consoleReader.getNextLine();

        if (usrRes.isEmpty()) {
            if (question.getDefaultAnswer().isEmpty()) {
                System.out.println("Please choose one of the options.");
                return askChoiceQuestion(question);
            }
            return question.getDefaultAnswer();
        }

        if (question.isValidAnswer(usrRes)) {
            return usrRes;
        } else {
            System.out.println("Invalid response. Please try again.");
            return askChoiceQuestion(question);
        }
    }

    @Deprecated
    public boolean askChoiceQuestion(String question) {
        System.out.printf("%s (y/n): ", question);
        String response = consoleReader.getNextString();

        if (response.equalsIgnoreCase("y")) {
            return true;
        } else if (response.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Invalid response. Please enter 'y' or 'n'.");
            return askChoiceQuestion(question);
        }
    }

    private List<String> getFormattedAnswersWithDefault(IQuestion question) {
        List<String> answers = question.getAnswers();
        String defaultAnswer = question.getDefaultAnswer();
        List<String> formattedAnswers = new ArrayList<>();

        for (String answer : answers) {
            if (defaultAnswer.equals(answer)) {
                formattedAnswers.add(answer.toUpperCase());
            } else {
                formattedAnswers.add(answer.toLowerCase());
            }
        }

        return formattedAnswers;
    }
}
