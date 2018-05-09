package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

/**
 * A Multiple choice question. It is displayed in {@link Test} activity.
 * Extends {@link question}.
 */
public class mcQuestion extends salazar.cs3354.txstate.edu.datapathsimulator.question {
    private int answerIndex;
    /**
     * The answer choices for the question.
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
