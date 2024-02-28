package nuk.userinput;

import java.util.List;

public interface IQuestion {
    public String getQuestion();
    public List<String> getAnswers();
    public List<String> getDefaultAnswers();
    public boolean isValidAnswer(String answer);
}
