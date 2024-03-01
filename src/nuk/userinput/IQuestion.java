package nuk.userinput;

import java.util.List;

public interface IQuestion {
    String getQuestion();

    List<String> getAnswers();

    String getDefaultAnswer();

    boolean isValidAnswer(String answer);
}
