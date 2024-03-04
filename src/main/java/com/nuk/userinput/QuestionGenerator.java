package com.nuk.userinput;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that generates questions in console and reads the user's response.
 * <p>
 * A ConsoleReader instance is needed in order to use the Question Generator.
 * Example usage:
 * </p>
 * {@snippet lang = java:
 * try (ConsoleReader consoleReader = new ConsoleReader()) {
 *     QuestionGenerator questionGenerator = consoleReader.getQuestionGenerator();
 *     // ...
 * }
 *}
 */
public class QuestionGenerator {

    private final ConsoleReader consoleReader;

    QuestionGenerator(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    /**
     * Asks the user a question with a set of possible answers.
     *
     * @param question
     *         the question object holding the question and possible answers
     *
     * @return the user's response
     */
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

    /**
     * Asks the user a question with y/n answers.
     *
     * @param question
     *         the question to ask
     *
     * @return the user's response
     * @deprecated use {@link #askChoiceQuestion(IQuestion)} instead
     */
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
