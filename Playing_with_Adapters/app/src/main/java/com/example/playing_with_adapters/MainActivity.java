package com.example.playing_with_adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView simpleListView;
    int flag_pics[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleListView=(ListView)findViewById(R.id.simpleListView);

        BaseAdapterTest myAdapter= new BaseAdapterTest(getApplicationContext(),flag_pics);

        simpleListView.setAdapter(myAdapter);
    }
}