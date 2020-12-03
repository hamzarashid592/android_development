package com.example.playing_with_adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_a extends AppCompatActivity {

    Button intentButton1, intentButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        intentButton1=(Button)findViewById(R.id.intentButton1);
        intentButton2=(Button)findViewById(R.id.intentButton2);

        intentButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent= new Intent(getApplicationContext(),Activity_b.class);
                startActivity(myIntent);
            }
        });

        intentButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent= new Intent(Intent.ACTION_VIEW);
                myIntent.setData(Uri.parse("https://www.youtube.com/"));
                startActivity(myIntent);
            }
        });
    }
}