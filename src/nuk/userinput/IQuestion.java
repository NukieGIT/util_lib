package nuk.userinput;

import java.util.List;

public interface IQuestion {
    public String getQuestion();
    public List<String> getAnswers();
    public String getDefaultAnswer();
    public boolean isValidAnswer(String answer);
}
