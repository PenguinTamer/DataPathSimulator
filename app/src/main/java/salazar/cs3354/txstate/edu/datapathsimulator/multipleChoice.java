package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

public class multipleChoice extends Question {
    ArrayList<String> untrueChoices;

    public multipleChoice(int qID, String question, String answer) {
        this.setQuestion(question);
        this.setqID(qID);
    }
}
