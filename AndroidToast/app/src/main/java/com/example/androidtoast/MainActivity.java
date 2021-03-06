package com.example.androidtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,toggleSubmit, switchSubmit;
    ToggleButton toggle1, toggle2;
    Switch sw1,sw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        toggleSubmit=(Button)findViewById(R.id.toggleResult);
        toggle1=(ToggleButton)findViewById(R.id.toggleButton1);
        toggle2=(ToggleButton)findViewById(R.id.toggleButton2);
        //Making switches:
        sw1=(Switch)findViewById(R.id.washing_machine_switch);
        sw2=(Switch)findViewById(R.id.fridge_switch);
        switchSubmit=(Button)findViewById(R.id.switchResult);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"This is a toast message",Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"This is Short",Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                LayoutInflater li= getLayoutInflater(); //This class fetches views from another layout.
                View layout=  li.inflate(R.layout.activity_custom_toast, (ViewGroup) findViewById(R.id.customToast)); //This method does the actual fetching. We pass the layout to be fetched here.

                Toast toast= new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(layout);
                toast.show();
            }
        });

        toggleSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                StringBuilder str_builder= new StringBuilder();
                str_builder.append("Radio State: ").append(toggle1.getText());
                str_builder.append("\nTV State: ").append(toggle2.getText());


                Toast toast= new Toast(getApplicationContext());
                toast.setText(str_builder.toString());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        toggle1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                StringBuilder str_builder= new StringBuilder();
                str_builder.append("Radio State: ").append(toggle1.getText());
                Toast toast= new Toast(getApplicationContext());
                toast.setText(str_builder.toString());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        toggle2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                StringBuilder str_builder= new StringBuilder();
                str_builder.append("TV State: ").append(toggle2.getText());
                Toast toast= new Toast(getApplicationContext());
                toast.setText(str_builder.toString());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        switchSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder str= new StringBuilder();
                if (sw1.isChecked())
                    str.append("Washing Wachine says: ").append(sw1.getTextOn());
                else
                    str.append("Washing Wachine says: ").append(sw1.getTextOff());
                if (sw2.isChecked())
                    str.append("\nFridge says: ").append(sw2.getTextOn());
                else
                    str.append("\nFridge says: ").append(sw2.getTextOff());

                Toast t= new Toast(getApplicationContext());
                t.setText(str.toString());
                t.setDuration(Toast.LENGTH_SHORT);
                t.show();
            }
        });

    }
}