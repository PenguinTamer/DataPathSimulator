package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

public class mcQuestion extends salazar.cs3354.txstate.edu.datapathsimulator.question {
    private String answer;
    public ArrayList<String> untrueChoices = new ArrayList<>();

    public mcQuestion() {
    }

    public mcQuestion(int qID, String question, String answer) {
        this.setqID(qID);
        this.setQuestion(question);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<String> getUntrueChoices() {
        return untrueChoices;
    }

    public void setUntrueChoices(String choice) {
        untrueChoices.add(choice);
    }
}
