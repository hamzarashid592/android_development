package com.example.playingwithdatastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText firstName, middleName, lastName, loadFirstName;
    Button load, save;

    TextView loadMiddleName, loadLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName=findViewById(R.id.editText1);
        middleName=findViewById(R.id.editText2);
        lastName=findViewById(R.id.editText3);
        loadFirstName=findViewById(R.id.editText4);
        loadMiddleName=findViewById(R.id.text5);
        loadLastName=findViewById(R.id.text6);
        load=findViewById(R.id.button2);
        save=findViewById(R.id.button1);

//        Making shared preference object.
        SharedPreferences sharedPreferences= getSharedPreferences("myData",getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Saving the data.
                editor.putString(firstName.getText().toString(),middleName.getText().toString()+" "+
                        lastName.getText().toString());
                editor.commit();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=loadFirstName.getText().toString();
                String full_name[]=sharedPreferences.getString(name,"NULL").split(" ");
                loadMiddleName.setText(full_name[0]);
                loadLastName.setText(full_name[1]);
            }
        });




    }
}