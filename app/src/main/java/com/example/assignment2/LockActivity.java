package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class LockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        // Buttons
        Button lockActivityBtn = findViewById(R.id.lockActivityBtn);
        Button unlockActivityBtn = findViewById(R.id.unlockAcitvityBtn);

    }
}
