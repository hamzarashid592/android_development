package com.example.androidtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);

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
    }
}