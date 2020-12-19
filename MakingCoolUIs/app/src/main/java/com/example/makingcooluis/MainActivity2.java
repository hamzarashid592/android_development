package com.example.makingcooluis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    CardView googleCard, facebookCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        googleCard=findViewById(R.id.googleCard);
        facebookCard=findViewById(R.id.facebookCard5);

        googleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You clicked google",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(intent);
            }
        });

        facebookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You clicked facebook",Toast.LENGTH_SHORT).show();
            }
        });

    }
}