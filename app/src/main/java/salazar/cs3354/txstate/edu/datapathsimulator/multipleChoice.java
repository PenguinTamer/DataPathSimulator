package salazar.cs3354.txstate.edu.datapathsimulator;

public class multipleChoice extends Question {

    public multipleChoice(String question, String answer, int qID) {
        this.setQuestion(question);
        this.setAnswer(answer);
        this.setqID(qID);
    }
}
