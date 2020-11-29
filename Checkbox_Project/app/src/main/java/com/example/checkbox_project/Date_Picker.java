package com.example.checkbox_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Date_Picker extends AppCompatActivity {

    Button dateButton;
    DatePicker datePicker;
    TextView dateText;

    int d,m,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date__picker);

//        Referencing..
        dateButton=(Button)findViewById(R.id.getDateButton);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        dateText=(TextView)findViewById(R.id.dateText);

        Calendar clndr= Calendar.getInstance();


        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder str= new StringBuilder();
                str.append(datePicker.getDayOfMonth()+"/").append((datePicker.getMonth()+1)+"/").append(datePicker.getYear());
                dateText.setText("Date is "+str.toString());
            }
        });


    }
}