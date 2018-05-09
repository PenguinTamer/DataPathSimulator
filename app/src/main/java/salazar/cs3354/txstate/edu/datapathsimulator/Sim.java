package salazar.cs3354.txstate.edu.datapathsimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Sim extends AppCompatActivity {
    //Handles
    /**Handle for dropdown containing choices for spinner 1 of row 1 in answer table*/
    /**Handle for dropdown containing choices for spinner 2 of row 1 in answer table*/
    /**Handle for dropdown containing choices for spinner 1 of row 2 in answer table*/
    /**
     * Handle for dropdown containing choices for spinner 2 of row 2 in answer table
     */
    private Spinner r1spinner1, r1spinner2, r2spinner1, r2spinner2;
    /**
     * Handle for the submit button that submits answers entered into answer table
     */
    private Button submitButton;
    //Variables
    /**
     * Holds all questions (simQuestion objects
     */
    private ArrayList<simQuestion> questions;

    /**
     * Initializes the content view for the activity
     * @param savedInstanceState keeps previous states for restoration of activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);
        //Initialize variables
        questions = new ArrayList<>();

    }

    private void initialize(ArrayList<simQuestion> questions) {
        simQuestion question;

        //Create new question
        question = new simQuestion();
        question.setQuestion("ALU");
        question.setType('A');
        question.setqID(1);
        question.setInfoID(-1);
        //Add Answers
        question.answers.add(null);
        question.answers.add(null);
        question.answers.add(null);
        question.answers.add(null);
        //Commit to array questions
        questions.add(question);
    }

    private void checkAnswers() {

    }
}
