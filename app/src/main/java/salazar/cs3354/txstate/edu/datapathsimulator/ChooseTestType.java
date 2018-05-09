package salazar.cs3354.txstate.edu.datapathsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Navigation activity for choosing the type of test the user would like to take, multiple choice or data path sim.
 * The user selects the type using two buttons, DpSim button and multipleChoiceButton.
 */
public class ChooseTestType extends AppCompatActivity {
    /**Handle for data path simulator navigation button*/
    /**
     * Handle for Multiple Choice navigation button
     */
    Button dpSimButton, multipleChoiceButton;

    /**
     * Provides an {@link android.view.View.OnClickListener} for the bottom navigation that determines
     * which button was pressed and takes the user to the corresponding activity
     *
     * @param intent provides the means to start new activities (E.g. Home, Practice, and Test)
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent = new Intent(ChooseTestType.this, MainActivity.class);
                    startActivity(intent);
                case R.id.navigation_practice:
                    intent = new Intent(ChooseTestType.this, practice.class);
                    startActivity(intent);
            }
            return false;
        }
    };

    /**
     *Holds all logic that execute on creation of activity. Handles are initialized and
     * {@link android.view.View.OnClickListener}'s are set for each of the two navigation buttons.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_test_type);

        //Initializing handles
        dpSimButton = findViewById(R.id.acvitity_ChooseTestType_Button_DP_Sim);
        multipleChoiceButton = findViewById(R.id.acvitity_ChooseTestType_Button_MultipleChoice);

        dpSimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTestType.this, DataPathSim.class);
                startActivity(intent);
            }
        });
        multipleChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTestType.this, Test.class);
                startActivity(intent);
            }
        });
    }

}
