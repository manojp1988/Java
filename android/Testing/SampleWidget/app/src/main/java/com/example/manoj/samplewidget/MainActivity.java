package com.example.manoj.samplewidget;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Debug.startMethodTracing("sample");

        Button progressDialogButton = (Button) findViewById(R.id.progress_dialog_button);
        progressDialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressDoalog = new ProgressDialog(MainActivity.this);
                    progressDoalog.setMax(100);
                    progressDoalog.setMessage("Its loading....");
                    progressDoalog.setTitle("ProgressDialog bar example");
                    progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDoalog.show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (progressDoalog.getProgress() <= progressDoalog
                                        .getMax()) {
                                    Thread.sleep(200);
                                    progressDoalog.incrementProgressBy(1);

                                    if (progressDoalog.getProgress() == progressDoalog
                                            .getMax()) {
                                        progressDoalog.dismiss();
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();

                }
            }
        );

        Debug.stopMethodTracing();

    }
}
