package com.example.assignment2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/*
* Advanced Activity 1: Alarm manager: https://www.youtube.com/watch?v=yrpimdBRk5Q
* Advanced Activity 2: Serialization
*/

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
                lockScreenPage();
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

        // Context menu
        registerForContextMenu(changeActivityBtn);
    }

    // Context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_1:
                Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.option_2:
                Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    private void lockScreenPage(){
        Intent startIntent = new Intent(getApplicationContext(), LockActivity.class);
        startActivity(startIntent);
    }

    private void extraActivityPage(){
        Intent startIntent = new Intent(getApplicationContext(), ExtraActivity.class);
        startActivity(startIntent);
    }

    private void alarmActivity(){
        Intent startIntent = new Intent(getApplicationContext(), AlarmActivity.class);
        startActivity(startIntent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // This places the menu on main activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();

                // Create an alert dialog builders
                AlertDialog dialog = new AlertDialog.Builder(this).create();

                // Create the alert dialog funcitonality
                dialog.setMessage("This is a menu for other pages.");
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Lock Activity",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                lockScreenPage();
                            }
                        });

                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Stay on main activity.",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        "You choose to stay on this page",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Go to extra activity",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                extraActivityPage();
                            }
                        });

                dialog.show();

                return true;

            case R.id.item2:
                alarmActivity();
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subitem1:
                Toast.makeText(this, "Subitem 1 selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subitem2:
                Toast.makeText(this, "Subitem 2 selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
