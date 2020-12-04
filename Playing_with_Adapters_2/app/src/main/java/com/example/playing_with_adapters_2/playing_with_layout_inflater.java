package com.example.playing_with_adapters_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class playing_with_layout_inflater extends AppCompatActivity {

    LinearLayout inflaterLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_with_layout_inflater);

        inflaterLinearLayout=(LinearLayout)findViewById(R.id.inflaterLinearLayout);

//        First method
//        LayoutInflater li= getLayoutInflater();
//        View view=li.inflate(R.layout.simple_text,null); //We have passed null as parent here.
//        inflaterLinearLayout.addView(view); //Making the view child of the linear layout.

//        Second method
//        LayoutInflater li= getLayoutInflater();
//        li.inflate(R.layout.simple_text,inflaterLinearLayout);

        //        Third method
        LayoutInflater li= getLayoutInflater();
        li.inflate(R.layout.simple_text,inflaterLinearLayout,true);

    }
}