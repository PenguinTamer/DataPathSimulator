package salazar.cs3354.txstate.edu.datapathsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Contains basic navigation functions for practice activity which contains slides of relevant
 * information for the test section of the app
 */
public class practice extends AppCompatActivity {

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
                    intent = new Intent(practice.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_test:
                    intent = new Intent(practice.this, ChooseTestType.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
