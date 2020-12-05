package com.example.playing_with_adapters_2;

import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class array_adapter_5 extends AppCompatActivity {

    Spinner mySpinner;
    String titles[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_5);

        mySpinner= findViewById(R.id.mySpinner);

        Resources res= getResources();
        titles=res.getStringArray(R.array.titles);

//        Style 1
//        ArrayAdapter adp=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,titles);

//        Style 2 (Better)
        ArrayAdapter adp=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,titles);

        mySpinner.setAdapter(adp);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView temp= (TextView) view;
                Toast.makeText(getApplicationContext(),temp.getText()+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}