package nuk.userinput;

import java.util.Collections;
import java.util.List;

public class GenericQuestion implements IQuestion {

    private String question;
    private List<String> answers;
    private String defaultAnswer;

    public GenericQuestion(String question, List<String> answers, String defaultAnswer) {
        this.question = question;
        this.answers = answers;
        this.defaultAnswer = defaultAnswer;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public List<String> getAnswers() {
        return Collections.unmodifiableList(answers);
    }

    @Override
    public String getDefaultAnswer() {
        return defaultAnswer;
    }

    @Override
    public boolean isValidAnswer(String answer) {
        return getAnswers().stream().anyMatch(a -> a.equalsIgnoreCase(answer));
    }
}
