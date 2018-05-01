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

/**
 * Test.java contains logic for Test activity
 */
public class Test extends AppCompatActivity {
    /**
     * @param mcQuestionArrayList Holds all mcQuestion objects for the multiple choice test
     * @param questionIndex Tracks the current question displayed
     * @param questionsRight Keeps track of the number questions answered correctly
     * @param questionText is the handle for the primary textbox which displays the question to be answered
     * @param scoreText is the handle for the textbox that displays the user's score
     * @param choiceGroup is the handle for the radio button group containing the 4 answer choices
     * @param choice1 handle for radio button that contains answer choice 1
     * @param choice2 handle for radio button that contains answer choice 2
     * @param choice3 handle for radio button that contains answer choice 3
     * @param choice4 handle for radio button that contains answer choice 4
     * @param
     */
    //Variables
    private ArrayList<mcQuestion> mcQuestionArrayList;
    private int questionIndex = 0;
    private int questionsRight = 0;
    //Handles
    private TextView questionText;
    private TextView scoreText;
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
        scoreText = findViewById(R.id.score);
        choiceGroup = findViewById(R.id.choiceGroup);
        submitButton = findViewById(R.id.submitButton);
        explainButton = findViewById(R.id.explainButton);
        choice1 = findViewById(R.id.choiceButton1);
        choice2 = findViewById(R.id.choiceButton2);
        choice3 = findViewById(R.id.choiceButton3);
        choice4 = findViewById(R.id.choiceButton4);

        //Initialization of questions
        mcQuestionArrayList = new ArrayList<>();
        initialize(mcQuestionArrayList);
        updateQuestion();

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
                } else if (selectedButtonId == choice4.getId()) {
                    checkAnswer(mcQuestionArrayList.get(questionIndex), 3);
                }

                if (questionIndex == mcQuestionArrayList.size() - 1) {
                    showScore();
                } else {
                    questionIndex++;
                    updateQuestion();
                }
            }
        });

        explainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeActivity;

                switch (mcQuestionArrayList.get(questionIndex).getInfoID()) {
                    case 0:
                        changeActivity = new Intent(Test.this, answer1.class);
                        break;
                    case 1:
                        changeActivity = new Intent(Test.this, answer2.class);
                        break;
                    case 2:
                        changeActivity = new Intent(Test.this, answer3.class);
                        break;
                    case 3:
                        changeActivity = new Intent(Test.this, answer4.class);
                        break;
                    case 4:
                    case 7:
                        changeActivity = new Intent(Test.this, answer58.class);
                        break;
                    case 5:
                        changeActivity = new Intent(Test.this, answer6.class);
                        break;
                    case 6:
                        changeActivity = new Intent(Test.this, answer7.class);
                        break;
                    default:
                        changeActivity = new Intent(Test.this, practice.class);
                        break;
                }
                startActivity(changeActivity);
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
        mcQuestion.setAnswerIndex(2);
        mcQuestion.setQuestion("Which of the following is NOT a datapath element?");
        mcQuestion.choices.add("ALU");
        mcQuestion.choices.add("Multiplexer");
        mcQuestion.choices.add("RAM");
        mcQuestion.choices.add("Gates");
        mcQuestionArrayList.add(mcQuestion);

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(1);
        mcQuestion.setInfoID(1);
        mcQuestion.setAnswerIndex(0);
        mcQuestion.setQuestion("Which of the following is a state element?");
        mcQuestion.choices.add("Registers");
        mcQuestion.choices.add("ALU");
        mcQuestion.choices.add("Multiplexer");
        mcQuestion.choices.add("Gates");
        mcQuestionArrayList.add(mcQuestion);

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(2);
        mcQuestion.setInfoID(2);
        mcQuestion.setAnswerIndex(1);
        mcQuestion.setQuestion("In order to execute an instruction fetch, which of the following components is NOT needed?");
        mcQuestion.choices.add("Memory");
        mcQuestion.choices.add("Registers");
        mcQuestion.choices.add("PC");
        mcQuestion.choices.add("ALU");
        mcQuestionArrayList.add(mcQuestion);

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(3);
        mcQuestion.setInfoID(3);
        mcQuestion.setAnswerIndex(3);
        mcQuestion.setQuestion("The set of components that tells the datapath what to do is referred to as the ");
        mcQuestion.choices.add("operating system");
        mcQuestion.choices.add("brain");
        mcQuestion.choices.add("boss");
        mcQuestion.choices.add("control");
        mcQuestionArrayList.add(mcQuestion);

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(4);
        mcQuestion.setInfoID(4);
        mcQuestion.setAnswerIndex(0);
        mcQuestion.setQuestion("The on chip memory holds up to ");
        mcQuestion.choices.add("L1 cache");
        mcQuestion.choices.add("L2 cache");
        mcQuestion.choices.add("main memory");
        mcQuestion.choices.add("disk");
        mcQuestionArrayList.add(mcQuestion);

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(5);
        mcQuestion.setInfoID(5);
        mcQuestion.setAnswerIndex(2);
        mcQuestion.setQuestion("Which tasks need to be performed for EVERY instruction?");
        mcQuestion.choices.add("Fetch");
        mcQuestion.choices.add("Decode");
        mcQuestion.choices.add("Both fetch & decode");
        mcQuestion.choices.add("None of the above");
        mcQuestionArrayList.add(mcQuestion);

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(6);
        mcQuestion.setInfoID(6);
        mcQuestion.setAnswerIndex(3);
        mcQuestion.setQuestion("At any given cycle, control must ");
        mcQuestion.choices.add("tell each MUX which operand to select");
        mcQuestion.choices.add("tell ALU which operation to perform");
        mcQuestion.choices.add("let registers & memory know if we are doing a read or write");
        mcQuestion.choices.add("all of the above");
        mcQuestionArrayList.add(mcQuestion);

        mcQuestion = new mcQuestion();
        mcQuestion.setqID(7);
        mcQuestion.setInfoID(7);
        mcQuestion.setAnswerIndex(1);
        mcQuestion.setQuestion("Which of the following is true regarding on chip memory?");
        mcQuestion.choices.add("Faster than registers & main memory");
        mcQuestion.choices.add("Larger than registers, but smaller than memory");
        mcQuestion.choices.add("Slower than main memory, but faster than registers");
        mcQuestion.choices.add("Smaller than registers & main memory");
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
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong, please move on", Toast.LENGTH_LONG).show();
        }
    }

    private void showScore() {
        scoreText.setVisibility(View.VISIBLE);
        scoreText.setText("Your Score is : " + questionsRight + " out of " + mcQuestionArrayList.size());
        questionText.setText("Good Job!");

        choiceGroup.setVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);
        explainButton.setVisibility(View.GONE);
    }

}
