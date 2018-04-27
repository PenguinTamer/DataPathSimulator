package salazar.cs3354.txstate.edu.datapathsimulator;

import java.util.ArrayList;

public class mcQuestion extends salazar.cs3354.txstate.edu.datapathsimulator.question {
    private String answer;
    public ArrayList<mcQuestion> ArrayList = new ArrayList<>();
    public ArrayList<String> untrueChoices = new ArrayList<>();

    /**
     * mcQuestion is where we populate the mcQuestion array via hardcode
     */
    public mcQuestion() {
        mcQuestion question1 = new mcQuestion();
        question1.setqID(1);
        question1.setQuestion("Question1");
        question1.answer = "Ans1";
        question1.untrueChoices.add(1, "Choice1");
        question1.untrueChoices.add(2, "choice2");
        question1.untrueChoices.add(3, "choice3");
        ArrayList.add(question1);

        mcQuestion question2 = new mcQuestion();
        question1.setqID(2);
        question1.setQuestion("Question2");
        question1.answer = "Ans2";
        question1.untrueChoices.add(1, "Choice1");
        question1.untrueChoices.add(2, "choice2");
        question1.untrueChoices.add(3, "choice3");
        ArrayList.add(question2);

        mcQuestion question3 = new mcQuestion();
        question1.setqID(3);
        question1.setQuestion("Question3");
        question1.answer = "Ans3";
        question1.untrueChoices.add(1, "Choice1");
        question1.untrueChoices.add(2, "choice2");
        question1.untrueChoices.add(3, "choice3");
        ArrayList.add(question3);
    }

    public mcQuestion(int qID, String question, String answer, String choice1, String choice2, String choice3) {
        this.setqID(qID);
        this.setQuestion(question);
        this.answer = answer;
        untrueChoices.add(1, choice1);
        untrueChoices.add(2, choice2);
        untrueChoices.add(3, choice3);
    }

    public String getAnswer() {
        return answer;
    }

    public java.util.ArrayList<mcQuestion> getArrayList() {
        return ArrayList;
    }

    public java.util.ArrayList<String> getUntrueChoices() {
        return untrueChoices;
    }
}
