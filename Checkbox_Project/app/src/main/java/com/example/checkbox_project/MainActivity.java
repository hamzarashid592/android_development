package com.example.checkbox_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    CheckBox cb1, cb2, cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Referencing the views...
        submitButton=(Button)findViewById(R.id.submitButton);
        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        cb4=(CheckBox)findViewById(R.id.cb4);

//        Button on click listener.
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder str= new StringBuilder();
                str.append("You have ordered: ");
                //        Checking the check boxes.
                if(cb1.isChecked())
                    str.append("\nZinger Burger");
                if(cb2.isChecked())
                    str.append("\nPizza");
                if(cb3.isChecked())
                    str.append("\nBiryani");
                if(cb4.isChecked())
                    str.append("\nQorma");

//        Making the toast message..
                Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}