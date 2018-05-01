package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

/**
 * The type Mc question.
 */
public class mcQuestion extends salazar.cs3354.txstate.edu.datapathsimulator.question {
    private int answerIndex;
    /**
     * The Choices.
     */
    public ArrayList<String> choices = new ArrayList<>();

    /**
     * Instantiates a new Mc question.
     */
    public mcQuestion() {
    }

    /**
     * Sets answer index.
     *
     * @param answerIndex the answer index
     */
    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    /**
     * Gets answer index.
     *
     * @return the answer index
     */
    public int getAnswerIndex() {
        return answerIndex;
    }
}
