package salazar.cs3354.txstate.edu.datapathsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Contains basic navigation function for the Home activity (MainActivity)
 */
public class MainActivity extends AppCompatActivity {

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
            Intent changeActivity;
            switch (item.getItemId()) {
                case R.id.navigation_practice:
                    changeActivity = new Intent(MainActivity.this, practice.class);
                    startActivity(changeActivity);
                    return true;
                case R.id.navigation_test:
                    changeActivity = new Intent(MainActivity.this, ChooseTestType.class);
                    startActivity(changeActivity);
                    return true;
            }
            return false;
        }
    };
    /**
     * Initializes the content view for the activity
     * @param savedInstanceState keeps previous states for restoration of activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
