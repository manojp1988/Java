package com.example.manoj.sampletestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameTextView = (EditText) findViewById(R.id.nameTextView);
        final TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        Button sayHelloButton = (Button) findViewById(R.id.sayHello);

        sayHelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameTextView.getText().toString();
                welcomeTextView.setText("Welcome "+name);
            }
        });


        Button gotoSpinnerButton = (Button) findViewById(R.id.gotoSpinner);

        gotoSpinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });

    }
}
