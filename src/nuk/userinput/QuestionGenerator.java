package nuk.userinput;

import java.util.ArrayList;
import java.util.List;

public class QuestionGenerator {

    private final ConsoleReader consoleReader;

    QuestionGenerator(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public String askQuestion(IQuestion question) {
        var formattedAnswers = getFormattedAnswersWithDefault(question);
        System.out.printf("%s (%s)", question.getQuestion(), String.join("|", formattedAnswers));

        String usrRes = consoleReader.getNextString();
        if (question.isValidAnswer(usrRes)) {
            return usrRes;
        } else {
            System.out.println("Invalid response. Please try again.");
            return askQuestion(question);
        }
    }

    @Deprecated
    public boolean askQuestion(String question) {
        System.out.printf("%s (y/n): ", question);
        String response = consoleReader.getNextString();

        if (response.equalsIgnoreCase("y")) {
            return true;
        } else if (response.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Invalid response. Please enter 'y' or 'n'.");
            return askQuestion(question);
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
