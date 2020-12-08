package com.example.makingflexibleui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity2 extends AppCompatActivity implements FragmentA.FragmentCommunicator{

    FragmentA fragmentA;
    FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        fragmentA = new FragmentA();

        FragmentManager manager= getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction= manager.beginTransaction();
        transaction.replace(R.id.linear1,fragmentA,"fragmentA");

//        If the landscape mode is used.
        if (getResources().getConfiguration().orientation==2){
            fragmentB= new FragmentB();
            transaction.replace(R.id.linear2,fragmentB,"fragmentB");
        }

        transaction.commit();

    }

    @Override
    public void communicator(Integer data) {
        Resources resources= getResources();
        String contents[]=resources.getStringArray(R.array.contents);

//        If screen is in landscape mode.
        if (getResources().getConfiguration().orientation==2){
            FragmentB fragmentB= (FragmentB) getSupportFragmentManager().findFragmentByTag("fragmentB");
            fragmentB.changeText(contents[data]);
        }
//        But for portrait mode I have to switch to another activity.
        else{

            Intent intent= new Intent(getApplicationContext(),MainActivity3.class);
            intent.putExtra("data",data);
            startActivity(intent);
        }

    }
}