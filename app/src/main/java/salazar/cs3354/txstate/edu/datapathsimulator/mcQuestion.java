package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

public class mcQuestion extends salazar.cs3354.txstate.edu.datapathsimulator.question {
    private int answerIndex;
    public ArrayList<String> choices = new ArrayList<>();

    public mcQuestion() {
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
}
