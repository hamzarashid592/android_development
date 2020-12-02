package com.example.playing_with_adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView simpleGridView;
    int flag_pics[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleGridView=(GridView)findViewById(R.id.simpleGridView);

        BaseAdapterTest myAdapter= new BaseAdapterTest(getApplicationContext(),flag_pics);

        simpleGridView.setAdapter(myAdapter);
    }
}