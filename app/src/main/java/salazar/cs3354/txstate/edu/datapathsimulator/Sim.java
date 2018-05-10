package salazar.cs3354.txstate.edu.datapathsimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sim extends AppCompatActivity {
    //Handles
    /**Handle for dropdown containing choices for spinner 1 of row 1 in answer table*/
    /**Handle for dropdown containing choices for spinner 2 of row 1 in answer table*/
    /**Handle for dropdown containing choices for spinner 1 of row 2 in answer table*/
    /**Handle for dropdown containing choices for spinner 2 of row 2 in answer table*/
    /**Handle for dropdown containing choices for spinner 1 of row 3 in answer table*/
    /**Handle for dropdown containing choices for spinner 2 of row 3 in answer table*/
    /**Handle for dropdown containing choices for spinner 1 of row 4 in answer table*/
    /**Handle for dropdown containing choices for spinner 2 of row 4 in answer table*/
    /**Handle for dropdown containing choices for spinner 1 of row 5 in answer table*/
    /**Handle for dropdown containing choices for spinner 2 of row 5 in answer table*/
    /**Handle for dropdown containing choices for spinner 1 of row 6 in answer table*/
    /**Handle for dropdown containing choices for spinner 2 of row 6 in answer table*/
    /**Handle for dropdown containing choices for spinner 1 of row 7 in answer table*/
    /**
     * Handle for dropdown containing choices for spinner 2 of row 7 in answer table
     */
    private Spinner r1spinner1, r1spinner2, r2spinner1, r2spinner2, r3spinner1, r3spinner2,
            r4spinner1, r4spinner2, r5spinner1, r5spinner2, r6spinner1, r6spinner2, r7spinner1,
            r7spinner2;
    /**
     * Handle for the submit button that submits answers entered into answer table
     */
    private Button submitButton;
    /**
     * Handle for the title of sim activity
     */
    private TextView instType;
    //Variables
    /**
     * Holds question (simQuestion object)
     */
    private simQuestion question;

    /**
     * Initializes the content view for the activity
     * @param savedInstanceState keeps previous states for restoration of activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);

        //Initialize handles
        r1spinner1 = findViewById(R.id.r1spinner1);
        r1spinner2 = findViewById(R.id.r1spinner2);
        r2spinner1 = findViewById(R.id.r2spinner1);
        r2spinner2 = findViewById(R.id.r2spinner2);
        r3spinner1 = findViewById(R.id.r3spinner1);
        r3spinner2 = findViewById(R.id.r3spinner2);
        r4spinner1 = findViewById(R.id.r4spinner1);
        r4spinner2 = findViewById(R.id.r4spinner2);
        r5spinner1 = findViewById(R.id.r5spinner1);
        r5spinner2 = findViewById(R.id.r5spinner2);
        r6spinner1 = findViewById(R.id.r6spinner1);
        r6spinner2 = findViewById(R.id.r6spinner2);
        r7spinner1 = findViewById(R.id.r7spinner1);
        r7spinner2 = findViewById(R.id.r7spinner2);
        //Initialize variables
        question = initialize(getIntent().getExtras().getChar("type"));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAnswers(question, getAnswers())) {
                    Toast.makeText(getApplicationContext(), "You got it right!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "You got it wrong!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private simQuestion initialize(char type) {
        simQuestion question;
        switch (type) {
            case 'A':
            case 'a':
                //Create new question
                question = new simQuestion();
                question.setQuestion("ALU Instruction");
                question.setType('A');
                question.setqID(-1);
                question.setInfoID(-1);
                //Add Answers
                question.answers.add(12);
                question.answers.add(13);
                question.answers.add(14);
                question.answers.add(710);
                question.answers.add(811);
                question.answers.add(125);
                break;
            case 'L':
            case 'l':
                //Create new question
                question = new simQuestion();
                question.setQuestion("Load Instruction");
                question.setType('L');
                question.setqID(-1);
                question.setInfoID(-1);
                //Add Answers
                question.answers.add(12);
                question.answers.add(14);
                question.answers.add(16);
                question.answers.add(710);
                question.answers.add(911);
                question.answers.add(1213);
                question.answers.add(1515);
                break;
            case 'S':
            case 's':
                //Create new question
                question = new simQuestion();
                question.setQuestion("Store Instruction");
                question.setType('S');
                question.setqID(-1);
                question.setInfoID(-1);
                //Add Answers
                question.answers.add(12);
                question.answers.add(13);
                question.answers.add(16);
                question.answers.add(710);
                question.answers.add(911);
                question.answers.add(1213);
                question.answers.add(814);
                break;
            default:
                question = new simQuestion();
        }
        return question;
    }

    private ArrayList getAnswers() {
        ArrayList<Integer> userAnswers = new ArrayList<>();
        userAnswers.add(Integer.valueOf(r1spinner1.getSelectedItem().toString().concat(r1spinner2.getSelectedItem().toString())));
        userAnswers.add(Integer.valueOf(r2spinner1.getSelectedItem().toString().concat(r2spinner2.getSelectedItem().toString())));
        userAnswers.add(Integer.valueOf(r3spinner1.getSelectedItem().toString().concat(r3spinner2.getSelectedItem().toString())));
        userAnswers.add(Integer.valueOf(r4spinner1.getSelectedItem().toString().concat(r4spinner2.getSelectedItem().toString())));
        userAnswers.add(Integer.valueOf(r5spinner1.getSelectedItem().toString().concat(r5spinner2.getSelectedItem().toString())));
        userAnswers.add(Integer.valueOf(r6spinner1.getSelectedItem().toString().concat(r6spinner2.getSelectedItem().toString())));
        userAnswers.add(Integer.valueOf(r7spinner1.getSelectedItem().toString().concat(r7spinner2.getSelectedItem().toString())));
        return userAnswers;
    }

    private boolean checkAnswers(simQuestion question, ArrayList<Integer> userAnswers) {
        for (int i = 0; i < question.answers.size(); i++)
            for (int j = 0; j < userAnswers.size(); j++) {
                if (question.answers.get(i) != userAnswers.get(j)) {
                    return false;
                }
            }
        return true;
    }
}
