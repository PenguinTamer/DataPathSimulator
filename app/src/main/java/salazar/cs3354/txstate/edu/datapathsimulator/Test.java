package salazar.cs3354.txstate.edu.datapathsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Test extends AppCompatActivity {
    private ArrayList<mcQuestion> mcQuestionArrayList;
    private int questionIndex = 0;
    private int questionsRight = 0;
    mcQuestion question = new mcQuestion();
    //Handles
    private TextView questionText;
    private RadioGroup choiceGroup;
    private RadioButton choice1, choice2, choice3, choice4;
    private Button explainButton, submitButton;


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
        submitButton = findViewById(R.id.submitButton);
        explainButton = findViewById(R.id.explainButton);
        choice1 = findViewById(R.id.choiceButton1);
        choice2 = findViewById(R.id.choiceButton2);
        choice3 = findViewById(R.id.choiceButton3);
        choice4 = findViewById(R.id.choiceButton4);

        //Initalization of questions
        mcQuestionArrayList = new ArrayList<>();
        initialize(mcQuestionArrayList);
        updateQuestion();

        /*choiceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //Checks which buttons has been pressed
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.choiceButton1) {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 0);
                } else if (checkedId == R.id.choiceButton2) {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 1);
                } else if (checkedId == R.id.choiceButton3) {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 2);
                } else {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 3);
                }
            }
        });*/
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = choiceGroup.getCheckedRadioButtonId();

                if (selectedButtonId == choice1.getId()) {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 0);
                } else if (selectedButtonId == choice2.getId()) {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 1);
                } else if (selectedButtonId == choice3.getId()) {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 2);
                } else {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 3);
                }
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initialize(ArrayList<mcQuestion> mcQuestionArrayList) {
        mcQuestion mcQuestion;

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(0);
        mcQuestion.setInfoID(0);
        mcQuestion.setAnswerIndex(0);
        mcQuestion.setQuestion("Question1");
        mcQuestion.choices.add("Ans1");
        mcQuestion.choices.add("Choice1");
        mcQuestion.choices.add("choice2");
        mcQuestion.choices.add("choice3");
        mcQuestionArrayList.add(mcQuestion);

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(1);
        mcQuestion.setInfoID(1);
        mcQuestion.setAnswerIndex(0);
        mcQuestion.setQuestion("Question2");
        mcQuestion.choices.add("ans2");
        mcQuestion.choices.add("Choice1");
        mcQuestion.choices.add("choice2");
        mcQuestion.choices.add("choice3");
        mcQuestionArrayList.add(mcQuestion);
    }

    private void updateQuestion() {
        questionText.setText(mcQuestionArrayList.get(questionIndex).getQuestion());
        choice1.setText(mcQuestionArrayList.get(questionIndex).choices.get(0));
        choice2.setText(mcQuestionArrayList.get(questionIndex).choices.get(1));
        choice3.setText(mcQuestionArrayList.get(questionIndex).choices.get(2));
        choice4.setText(mcQuestionArrayList.get(questionIndex).choices.get(3));
    }

    private void checkAnswer(mcQuestion question, int givenAnswerIndex) {
        if (givenAnswerIndex == question.getAnswerIndex()) {
            questionsRight++;
            questionIndex = (questionIndex + 1) % mcQuestionArrayList.size();
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT);
            updateQuestion();

        } else {
            Toast.makeText(getApplicationContext(), "Wrong, try again!", Toast.LENGTH_LONG);
        }
    }
}
