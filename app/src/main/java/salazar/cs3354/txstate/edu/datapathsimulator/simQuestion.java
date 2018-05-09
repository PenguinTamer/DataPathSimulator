package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

/**
 * A Data Path Sim question. Displayed within the {@link DataPathSim} activity, each question will be an
 * object of simQuestion.
 * Extends {@link question}.
 */
public class simQuestion extends question {
    /**
     * contains the answers to the DP sim problem. Each answer is made up of concatenated integers.
     * These integers are derived from the user's input within the data
     */
    public ArrayList<Integer> answers = new ArrayList<>();
    /**
     * Represents the type of instruction. Alu, Load, or Store.
     */
    private char type;

    /**
     * Instantiates a new instance of simQuestion
     */
    public simQuestion() {
    }

    /**
     * Gets type.
     *
     * @return the type of instruction the problem is
     */
    public char getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type of instruction
     */
    public void setType(char type) {
        this.type = type;
    }
}