package com.intertech.customviewsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.intertech.customviews.ValueBar;
import com.intertech.customviews.ValueSelector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ValueSelector valueSelector = (ValueSelector) findViewById(R.id.valueSelector);
        valueSelector.setMinValue(0);
        valueSelector.setMaxValue(100);


        final ValueBar valueBar = (ValueBar) findViewById(R.id.valueBar);
        valueBar.setMaxValue(100);
        valueBar.setAnimated(true);
        valueBar.setAnimationDuration(1000l);

        /*Button updateButton = (Button) findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = valueSelector.getValue();
                valueBar.setValue(value);

                //code to use Object Animation instead of the built-in ValueBar animation
                //if you use this, be sure the call valueBar.setAnimated(false);
                *//*
                ObjectAnimator anim = ObjectAnimator.ofInt(valueBar, "value", valueBar.getValue(), value);
                anim.setDuration(1000);
                anim.start();
                *//*
            }
        });*/

        valueBar.setOnValueBarMoved(new ValueBar.OnValueBarMoved() {
            @Override
            public void movedTo(int newPosition) {
                Toast.makeText(MainActivity.this, String.valueOf(newPosition), Toast.LENGTH_SHORT).show();
                valueSelector.setValue(newPosition);
            }
        });

        valueSelector.setOnValueSelectListener(new ValueSelector.OnValueSelectListener() {
            @Override
            public void selectedValue(int i) {
                valueBar.setValue(i);
            }
        });
    }
}
