package com.example.checkbox_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Working_with_Progress_Bar extends AppCompatActivity {

    ProgressBar circularProgressBar, horizontalProgressBar;
    Button horizontalProgressButton, circularProgressButton;
    TextView horizontalProgressText, circularProgressText;
    int i,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_with__progress__bar);

//        Referencing..
        circularProgressBar=(ProgressBar)findViewById(R.id.circularProgressBar);
        circularProgressButton=(Button)findViewById(R.id.circularProgressButton);
        circularProgressText=(TextView) findViewById(R.id.circularProgressText);

        horizontalProgressBar=(ProgressBar)findViewById(R.id.horizontalProgressBar);
        horizontalProgressButton=(Button)findViewById(R.id.horizontalProgressButton);
        horizontalProgressText=(TextView) findViewById(R.id.horizontalProgressText);

        horizontalProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler hndlr= new Handler(Looper.getMainLooper());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (i = 0; i <= 100; i++) {
                            hndlr.post(new Runnable() {
                                @Override
                                public void run() {
                                    horizontalProgressBar.setProgress(i);
                                    horizontalProgressText.setText("Progress: " + i + "/100");
                                }
                            });
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler hndlr= new Handler(Looper.getMainLooper());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (j = 0; j <= 100; j++) {
                            hndlr.post(new Runnable() {
                                @Override
                                public void run() {
                                    circularProgressBar.setProgress(j);
                                    circularProgressText.setText("Progress: " + j + "/100");
                                }
                            });
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

    }
}