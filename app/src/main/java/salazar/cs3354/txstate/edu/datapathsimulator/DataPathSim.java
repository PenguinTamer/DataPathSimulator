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
 * Contains Logic for DataPathSim activity. Allows the user to navigate different questions based
 * on instruction types. ALU, Store, or Load
 */
public class DataPathSim extends AppCompatActivity {

    /**The handle for the ALU Button that navigates to the ALU Sim question*/
    /**The handle for the Load Button that navigates to the Load Sim question*/
    /**
     * The handle for the Store Button that navigates to the Store Sim question
     */
    private Button aluButton, loadButton, storeButton;

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
                    intent = new Intent(DataPathSim.this, MainActivity.class);
                    startActivity(intent);
                case R.id.navigation_practice:
                    intent = new Intent(DataPathSim.this, practice.class);
                    startActivity(intent);
                case R.id.navigation_test:
                    intent = new Intent(DataPathSim.this, ChooseTestType.class);
                    startActivity(intent);
            }
            return false;
        }
    };

    /**
     *Holds all logic that execute on creation of activity. Handles are initialized and
     * {@link android.view.View.OnClickListener}'s are set for each of the three navigation buttons.
     * @param savedInstanceState keeps previous states for restoration of activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_path_sim);

        aluButton = findViewById(R.id.dataPathSim_ALU_Button);
        loadButton = findViewById(R.id.dataPathSim_Load_Button);
        storeButton = findViewById(R.id.dataPathSim_Store_Button);

        aluButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });
    }

}
