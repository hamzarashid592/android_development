package com.example.playing_with_adapters_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class array_adapter_2 extends AppCompatActivity {

    ListView listView;
    String data[]={"intention",
            "lead",
            "conspiracy",
            "civilization",
            "snake",
            "suffering",
            "dilute",
            "resist",
            "pluck",
            "move",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_2);

        listView=(ListView)findViewById(R.id.listView1);

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.row_layout,R.id.myText,data);
        listView.setAdapter(arrayAdapter);

    }
}