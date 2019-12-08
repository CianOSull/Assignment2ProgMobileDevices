package com.example.assignment2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class ExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        // Set paint
        Paint paint = new Paint();
        // Set color
        paint.setColor(Color.parseColor("#da4747"));

        // Set bitmap
        Bitmap bp = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);

        // Create the canvas
        Canvas canvas = new Canvas(bp);
        canvas.drawRect(50, 50, 200, 200, paint);

        LinearLayout rectLinLayout = findViewById(R.id.rectLinLayout);
        rectLinLayout.setBackground(new BitmapDrawable(bp));

        // This is the slider bit
        final SlidrInterface slidr = Slidr.attach(this);
    }
}
