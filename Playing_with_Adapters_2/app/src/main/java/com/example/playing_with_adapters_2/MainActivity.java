package com.example.playing_with_adapters_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

    ListView listView1l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1l=(ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
        listView1l.setAdapter(arrayAdapter);
        listView1l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView temp= (TextView) view;
                Toast.makeText(getApplicationContext(),temp.getText()+" "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}