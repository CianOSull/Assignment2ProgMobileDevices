package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.r0adkll.slidr.Slidr;

public class LockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        /*
        * Changes made to other files
        * The dependency/library we added to gradle was:
        * implementation 'com.r0adkll:slidableactivity:2.1.0'
        *
        * In Styles.xml we did:
        *  <style name="AppTheme.SliderActivityTheme">
                <item name="android:windowIsTranslucent">true</item>
                <item name="android:windowBackground">@android:color/transparent</item>
           </style>
           *
           * Inside of android manifest:
           * <activity android:name=".LockActivity"
            android:theme="@style/AppTheme.SliderActivityTheme"></activity>
            *
            * Inside of activity_lock.xml
            * android:background="@color/background_material_light"
            * This above sets teh background of the activity
         */

        // Buttons
        Button lockActivityBtn = findViewById(R.id.lockActivityBtn);
        Button unlockActivityBtn = findViewById(R.id.unlockAcitvityBtn);

        // This is the slider bit
        Slidr.attach(this);
    }
}
