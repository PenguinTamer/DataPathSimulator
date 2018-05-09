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
 * Test.java contains logic for Test activity, a multiple choice test.
 * It cycles through given questions (defined in the initialize method) by updating a {@link TextView} which
 * contains the question and a {@link RadioGroup} which contain the answer choices. It also displays
 * your score at the end.
 */
public class Test extends AppCompatActivity {

    //Variables
    /**Holds all mcQuestion objects for the multiple choice test*/
    private ArrayList<mcQuestion> mcQuestionArrayList;
    /**Tracks the current question displayed*/
    /**Keeps track of the number questions answered correctly*/
    private int questionIndex = 0, questionsRight = 0;

    //Handles
    /**is the handle for the primary text box which displays the question to be answered*/
    /**is the handle for the text box that displays the user's score*/
    private TextView questionText,scoreText;
    /**is the handle for the radio button group containing the 4 answer choices*/
    private RadioGroup choiceGroup;
    /**is the handle for radio button that contains answer choice 1*/
    /**is the handle for radio button that contains answer choice 2*/
    /**is the handle for radio button that contains answer choice 3*/
    /**is the handle for radio button that contains answer choice 4*/
    private RadioButton choice1, choice2, choice3, choice4;
    /**is the handle for the button which lets you view the answer activities*/
    /**is the handle for the submit button that must be pressed to commit a question answer*/
    private Button explainButton, submitButton;

    /**Provides an {@link android.view.View.OnClickListener} for the bottom navigation that determines
     * which button was pressed and takes the user to the corresponding activity
     * @param intent provides the means to start new activities (E.g. Home, Practice, and Test)
     * */
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

    /**
     * Holds all logic that execute on creation of activity. Handles are initialized and
     * {@link android.view.View.OnClickListener}'s are set for all button and radiobutton handles.
     * <p>
     * Questions are loaded in to UI based on the questionIndex
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //Initialization all handles by associating them to specific UI widgets by ID.
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

    /**
     * Method loads questions into "mcQuestionArrayList" within Test class
     * @param mcQuestionArrayList is passed from Test class to be populated
     */
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

    /**
     * Method updates question text along with choices to the current question using questionIndex as a guide
     */
    private void updateQuestion() {
        questionText.setText(mcQuestionArrayList.get(questionIndex).getQuestion());
        choice1.setText(mcQuestionArrayList.get(questionIndex).choices.get(0));
        choice2.setText(mcQuestionArrayList.get(questionIndex).choices.get(1));
        choice3.setText(mcQuestionArrayList.get(questionIndex).choices.get(2));
        choice4.setText(mcQuestionArrayList.get(questionIndex).choices.get(3));
    }

    /**
     * Method checks question's answer variable against the given answer and increments questionsRight
     * if the answer is correct
     * @param question holds the current question
     * @param givenAnswerIndex identifies the right choice by it's index within mcQuestion.choices array list
     */
    private void checkAnswer(mcQuestion question, int givenAnswerIndex) {
        if (givenAnswerIndex == question.getAnswerIndex()) {
            questionsRight++;
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong, please move on", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Reveals the user's score by hiding choiceGroup, submit/explain buttons, and setting scoreText to your final score
     */
    private void showScore() {
        scoreText.setVisibility(View.VISIBLE);
        scoreText.setText("Your Score is : " + questionsRight + " out of " + mcQuestionArrayList.size());
        questionText.setText("Good Job!");

        choiceGroup.setVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);
        explainButton.setVisibility(View.GONE);
    }

}
