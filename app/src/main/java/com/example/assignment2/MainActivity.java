package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * The area below initializes variables
        */
        // Text views
        final TextView radioTxtView = findViewById(R.id.radioTxtView);
        final TextView seekProgTxtView = findViewById(R.id.seekProgTxtView);

        // Buttons
        Button radioResultBtn = findViewById(R.id.radioResultBtn);
        Button changeActivityBtn = findViewById(R.id.changeActivityBtn);

        // Spinner
        Spinner spinner = findViewById(R.id.spinner);

        // Seek Bar
        SeekBar seekBar = findViewById(R.id.seekBar);

        // Progress Bar
        final ProgressBar progressBar = findViewById(R.id.progressBar);

        // Array adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.android_problems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Connecting spinner and adapter
        spinner.setAdapter(adapter);
        // To get this to work we had to implement an interface for a listener
        spinner.setOnItemSelectedListener(this);

        radioResultBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Radio buttons
                RadioButton radioBtn1 = findViewById(R.id.radioBtn1);
                RadioButton radioBtn2 = findViewById(R.id.radioBtn2);
                RadioButton radioBtn3 = findViewById(R.id.radioBtn3);

                RadioGroup radioGroupMain = findViewById(R.id.radioGroupMain); // Radio group

                // This button will contain the checked radio button id
                RadioButton rb = findViewById(radioGroupMain.getCheckedRadioButtonId());

                if(rb == radioBtn1){
                    radioTxtView.setText("Do you want to develop an app!");
                }
                else if(rb == radioBtn2){
                    radioTxtView.setText("No! Don't develop his app!");
                }
                else{
                    radioTxtView.setText("Dammit Jerry! You failed again!");
                }
            }
        });

        changeActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), LockActivity.class);
                startActivity(startIntent);

            }
        });


        // This sets the changes for seek bar and progress bar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                seekProgTxtView.setText("" + progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_top, menu);
        return true;
    }
}
