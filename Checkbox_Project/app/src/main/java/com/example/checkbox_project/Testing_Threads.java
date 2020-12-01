package com.example.checkbox_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Testing_Threads extends AppCompatActivity {


    Button threadButton;
    Switch threadSwitch;

    public static final String TAG="Testing_Threads";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing__threads);


        threadButton=(Button)findViewById(R.id.threadButton);
        threadSwitch=(Switch)findViewById(R.id.threadSwitch);

//        Making runnable instance.
        RunnableImplementation runnable= new RunnableImplementation(10);


        threadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Making the UI thread execute the following. This will hog up the entire app.
//                for (int i=0;i<5;i++){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                Invoking the thread by first instantiating a thread having the runnable object as the parameter and then calling the run method.
                new Thread(runnable).start();

            }
        });
    }
    class RunnableImplementation implements Runnable{
        int sec;

        RunnableImplementation(int sec){
            this.sec=sec;
        }

        @Override
        public void run() {
            for (int i=0;i<sec;i++){
                try {
                    Log.d(TAG,"Iteration: "+i+"\n");
                    Thread.sleep(1000);
//
//                    Changing button text if timer reaches 5. We are forcing a thread to alter the views created in the UI thread.
//                    if (i==5){
//                        threadButton.setText("Ouch.!!");
//                    }

//                  Using a handler to make our thread to communicate with views of UI thread.
//                    if (i==5){
//                        Handler hndlr= new Handler((Looper.getMainLooper()));
//                        hndlr.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                threadButton.setText("Ouch...!!");
//                            }
//                        });
//                    }

//                    Using the post method directly associated with the views.
                    if (i==5){
                        threadButton.post(new Runnable() {
                            @Override
                            public void run() {
                                threadButton.setText("Ouch...!!");
                            }
                        });
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
        }
    }
}
