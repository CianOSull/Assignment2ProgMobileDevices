package com.example.assignment2.Intentservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.assignment2.MainActivity;
import com.example.assignment2.R;

public class IntentServiceActivity extends AppCompatActivity {
    private EditText inputEdTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        inputEdTxt = findViewById(R.id.inputEdTxt);

        Button serviceBtn = findViewById(R.id.serviceBtn);
        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });

        Button mainBackBtn = findViewById(R.id.mainBackBtn);
        mainBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
    }

    public void startService(){
        String input = inputEdTxt.getText().toString();

        Intent serviceIntent = new Intent(this, MyIntentService.class);
        serviceIntent.putExtra("inputExtra", input);

        ContextCompat.startForegroundService(this, serviceIntent);
    }
}
