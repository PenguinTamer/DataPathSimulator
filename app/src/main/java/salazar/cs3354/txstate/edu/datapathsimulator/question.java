package salazar.cs3354.txstate.edu.datapathsimulator;

/**
 * An abstract class that contains
 */
public abstract class question {
    private String question;
    private int qID;
    private int infoID;

    /**
     * Gets info id.
     *
     * @return the info id
     */
    public int getInfoID() {
        return infoID;
    }

    /**
     * Sets info id.
     *
     * @param infoID the info id
     */
    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }

    /**
     * Gets question.
     *
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets question.
     *
     * @param question the question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getqID() {
        return qID;
    }

    /**
     * Sets id.
     *
     * @param qID the q id
     */
    public void setqID(int qID) {
        this.qID = qID;
    }
}
