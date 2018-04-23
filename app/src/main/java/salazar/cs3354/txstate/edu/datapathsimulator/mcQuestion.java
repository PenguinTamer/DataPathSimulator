package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

public class mcQuestion extends salazar.cs3354.txstate.edu.datapathsimulator.question {
    ArrayList<String> untrueChoices;

    public mcQuestion(int qID, String question, String answer) {
        this.setQuestion(question);
        this.setqID(qID);
    }
}
