package salazar.cs3354.txstate.edu.datapathsimulator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Test extends AppCompatActivity {
    private ArrayList<mcQuestion> mcQuestionArrayList;
    private int questionIndex = 0;
    mcQuestion question = new mcQuestion();
    //Handles
    private TextView questionText;
    private RadioGroup choiceGroup;
    private RadioButton choice1, choice2, choice3, choice4;
    private Button explainButton;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent = new Intent(Test.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_practice:
                    intent = new Intent(Test.this, practice.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //init all handles
        questionText = findViewById(R.id.questionText);
        choiceGroup = findViewById(R.id.choiceGroup);
        choice1 = findViewById(R.id.choiceButton1);
        choice2 = findViewById(R.id.choiceButton2);
        choice3 = findViewById(R.id.choiceButton3);
        choice4 = findViewById(R.id.choiceButton4);
        //Initalization of questions
        mcQuestionArrayList = new ArrayList<>();
        initialize(mcQuestionArrayList);
        updateQuestion(questionText, choice1, choice2, choice3, choice4);

        choiceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //Checks which buttons has been pressed
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.choiceButton1) {

                } else if (checkedId == R.id.choiceButton2) {

                } else if (checkedId == R.id.choiceButton3) {

                } else {

                }
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        questionText = (TextView) findViewById(R.id.questionText);

    }

    private void initialize(ArrayList<mcQuestion> mcQuestionArrayList) {
        mcQuestion mcQuestion;

        mcQuestion = new mcQuestion();
        mcQuestion.setQuestion("Question1");
        mcQuestion.setAnswer("Ans1");
        mcQuestion.untrueChoices.add("Choice1");
        mcQuestion.untrueChoices.add("choice2");
        mcQuestion.untrueChoices.add("choice3");
        mcQuestionArrayList.add(mcQuestion);
    }

    private void updateQuestion(TextView questionText, RadioButton choice1, RadioButton choice2, RadioButton choice3, RadioButton choice4) {
        questionText.setText(mcQuestionArrayList.get(questionIndex).getQuestion());
        //WILL UPDATE TO RANDOMIZE CHOICE/ANSWER ORDER
        choice1.setText(mcQuestionArrayList.get(questionIndex).untrueChoices.get(0));
        choice2.setText(mcQuestionArrayList.get(questionIndex).untrueChoices.get(1));
        choice3.setText(mcQuestionArrayList.get(questionIndex).untrueChoices.get(2));
        choice4.setText(mcQuestionArrayList.get(questionIndex).getAnswer());
    }
    private boolean checkAnswer(mcQuestion question, String answer) {
        if (answer == question.getAnswer()) {

            return true;
        } else
            return false;
    }
}
