package com.example.playing_with_adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Testing_Simple_Adapter_A extends AppCompatActivity {

    GridView simpleAdapterGridView;

    String flag_names[]={"a","b","c","d","e"};
    int flag_images[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing__simple__adapter_);

        simpleAdapterGridView=(GridView)findViewById(R.id.simpleAdapterGridView);
        ArrayList <HashMap<String,String>> myList= new ArrayList<>();

        for (int i=0; i<flag_images.length;i++){
            HashMap<String,String> myMap= new HashMap<>();
            myMap.put("Name",flag_names[i]);
            myMap.put("Image", String.valueOf(flag_images[i]));
            myList.add(myMap);
        }
        String from[]={"Name","Image"};
        int to[]={R.id.simpleAdapterTextView,R.id.simpleAdapterImageView};

        SimpleAdapter myAdapter=new SimpleAdapter(this,myList,R.layout.activity_testing__simple__adapter__b,from,to);
        simpleAdapterGridView.setAdapter(myAdapter);

    }
}