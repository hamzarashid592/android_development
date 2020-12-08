package com.example.makingflexibleui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class MainActivity3 extends AppCompatActivity {

    FragmentB fragmentB;
    Intent myIntent;
    Integer data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.d("HAMZA","Started the third activity.");


        fragmentB = new FragmentB();
        FragmentManager manager= getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction= manager.beginTransaction();
        transaction.replace(R.id.linear2,fragmentB,"fragmentB");
        transaction.commit();

        myIntent=getIntent();
        data=myIntent.getIntExtra("data",0);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("HAMZA","OnStart of the the third activity.");


        Resources resources= getResources();
        String contents[]=resources.getStringArray(R.array.contents);

        fragmentB.changeText(contents[data]);
    }
}