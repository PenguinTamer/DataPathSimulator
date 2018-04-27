package salazar.cs3354.txstate.edu.datapathsimulator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Test extends AppCompatActivity {
    private TextView mTextMessage;
    private ArrayList<mcQuestion> mcQuestionArrayList;
    private int questionIndex = 0;

    mcQuestion question = new mcQuestion();
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
        mcQuestionArrayList = new ArrayList<>();
        initialize(mcQuestionArrayList);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

    private boolean checkAnswer(mcQuestion question, String answer) {
        if (answer == question.getAnswer()) {
            return true;
        } else
            return false;
    }
}
