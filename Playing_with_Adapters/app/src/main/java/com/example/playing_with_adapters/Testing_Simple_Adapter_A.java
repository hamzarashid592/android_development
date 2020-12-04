package com.example.playing_with_adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Testing_Simple_Adapter_A extends AppCompatActivity {

    ListView simpleAdapterListView;

    String flag_names[]={"a","b","c","d","e"};
    int flag_images[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing__simple__adapter_);

        simpleAdapterListView=(ListView)findViewById(R.id.simpleAdapterListView);

        ArrayList<HashMap<String, Integer>> arrayList= new ArrayList<HashMap<String, Integer>>();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i=0;i<flag_images.length;i++){
            hashMap.put("Image",flag_images[i]);
            arrayList.add(hashMap);
        }
        String from[]={"Image"};
        int to[]={R.id.simpleAdapterImageView};
        SimpleAdapter adp= new SimpleAdapter(getApplicationContext(),arrayList,R.layout.activity_testing__simple__adapter__b,from,to);
        simpleAdapterListView.setAdapter(adp);

    }
}