package com.example.playing_with_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button activityButton, secondFragmentButton, firstFragmentButton;
    ConstraintLayout constraintLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityButton=(Button)findViewById(R.id.activityButton);
        secondFragmentButton=(Button)findViewById(R.id.secondFragmentButton);
        firstFragmentButton=(Button)findViewById(R.id.firstFragmentButton);
        constraintLayout=(ConstraintLayout)findViewById(R.id.constraintLayout);


        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hi from activity",Toast.LENGTH_SHORT).show();
            }
        });

        firstFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new secondFragment());
            }
        });

        secondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new thirdFragment());
            }
        });
        
    }
    private void getFragment(androidx.fragment.app.Fragment myFragment){
        FragmentManager fm= getFragmentManager();
        androidx.fragment.app.FragmentTransaction frg_tran=getSupportFragmentManager().beginTransaction();
        frg_tran.replace(R.id.constraintLayout,myFragment);
        frg_tran.commit();
    }
}