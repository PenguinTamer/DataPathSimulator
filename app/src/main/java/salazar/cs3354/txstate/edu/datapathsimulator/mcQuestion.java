package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

public class mcQuestion extends salazar.cs3354.txstate.edu.datapathsimulator.question {
    private String answer;
    public ArrayList<String> untrueChoices = new ArrayList<>();

    public mcQuestion() {
    }

    public mcQuestion(int qID, String question, String answer, String choice1, String choice2, String choice3) {
        this.setqID(qID);
        this.setQuestion(question);
        this.answer = answer;
        untrueChoices.add(1, choice1);
        untrueChoices.add(2, choice2);
        untrueChoices.add(3, choice3);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
