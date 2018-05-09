package salazar.cs3354.txstate.edu.datapathsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DataPathSim extends AppCompatActivity {

    private Button aluButton, loadButton, storeButton;

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
