package salazar.cs3354.txstate.edu.datapathsimulator;

/**
 * An abstract class that contains common parameters for both sim and multiple choice questions.
 */
public abstract class question {
    /**The question text*/
    private String question;
    /**The question ID, used to keep track of which question this is*/
    private int qID;
    /**pertains to the ID of the activity that contains relevant information for the current question*/
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
     * @param infoID the info ID
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
     * @param question the question text
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
     * @param qID the question ID
     */
    public void setqID(int qID) {
        this.qID = qID;
    }
}
