package com.example.playing_with_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment_1 myFragment= new Fragment_1();
        FragmentManager manager= getSupportFragmentManager();

        androidx.fragment.app.FragmentTransaction transaction= manager.beginTransaction();

        transaction.add(R.id.fragment1_layout,myFragment,"Fragment_1");

        transaction.commit();
    }
}