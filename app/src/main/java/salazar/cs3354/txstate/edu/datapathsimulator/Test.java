package salazar.cs3354.txstate.edu.datapathsimulator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class Test extends AppCompatActivity {

    private TextView mTextMessage;
    ArrayList<mcQuestion> mcQuestionArrayList = new ArrayList<>();
    int questionIndex = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_practice:
                    mTextMessage.setText(R.string.title_activity_practice);
                    return true;
                case R.id.navigation_test:
                    mTextMessage.setText(R.string.title_test);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    final public void initializeMcQuestions() {
        mcQuestion mcQuestion1 = new mcQuestion(1, "Question1", "Answer1", "wrongc1", "wrongc2", "wrongc3");
        mcQuestion mcQuestion2 = new mcQuestion(2, "Question2", "Answer2", "wrongc1", "wrongc2", "wrongc3");
        mcQuestion mcQuestion3 = new mcQuestion(3, "Question3", "Answer3", "wrongc1", "wrongc2", "wrongc3");

        mcQuestionArrayList.add(1, mcQuestion1);
        mcQuestionArrayList.add(2, mcQuestion2);
        mcQuestionArrayList.add(3, mcQuestion3);
    }

}
