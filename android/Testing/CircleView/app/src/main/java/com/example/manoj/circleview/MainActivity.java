package com.example.manoj.circleview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Circle circle = (Circle) findViewById(R.id.circle);
        circle.setCircleColor(Color.RED);

        TextView text = (TextView) findViewById(R.id.textView);
        text.setText("Hello");

        Circle circle2 = (Circle) findViewById(R.id.circle);
        circle2.setCircleColor(Color.BLUE);

    }
}
