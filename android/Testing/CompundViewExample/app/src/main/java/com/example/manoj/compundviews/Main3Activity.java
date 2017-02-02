package com.example.manoj.compundviews;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity {

    private static final String TAG = "Main3Activity";

    Thread thread;
    private ProgressBar progressBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView = (TextView) findViewById(R.id.textView);
        progressBar  = (ProgressBar) findViewById(R.id.progressBar);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++) {
                    progressBar.setProgress(i);
                    final int finalI = i;
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(finalI));
                        }
                    });


                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

    }


}
