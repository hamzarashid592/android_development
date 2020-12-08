package com.example.makingflexibleui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentCommunicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null){
            FragmentA fragmentA = new FragmentA();
            FragmentB fragmentB = new FragmentB();
            FragmentManager manager= getSupportFragmentManager();
            androidx.fragment.app.FragmentTransaction transaction= manager.beginTransaction();
            transaction.replace(R.id.linear1,fragmentA,"fragmentA");
            transaction.replace(R.id.linear2,fragmentB,"fragmentB");

//            Initializing the fragment communicator object in A.
//            fragmentA.initilizeCommunicator(this);

            transaction.commit();
        }
    }

    @Override
    public void communicator(Integer data) {
        FragmentManager manager= getSupportFragmentManager();
        FragmentB frag= (FragmentB) manager.findFragmentByTag("fragmentB");

        Resources resources= getResources();
        String contents[]=resources.getStringArray(R.array.contents);


        frag.changeText(contents[data]);
    }
}