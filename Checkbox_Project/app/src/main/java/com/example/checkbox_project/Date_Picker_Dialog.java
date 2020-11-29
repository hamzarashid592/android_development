package com.example.checkbox_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Date_Picker_Dialog extends AppCompatActivity {

    Button dateDialogButton;
    TextView dateDialogText;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date__picker__dialog);

        dateDialogButton=(Button)findViewById(R.id.dateDialogButton);
        dateDialogText=(TextView)findViewById(R.id.dateDialogText);

        Calendar clndr=Calendar.getInstance();
        day=clndr.get(Calendar.DAY_OF_MONTH);
        month=clndr.get(Calendar.MONTH);
        year=clndr.get(Calendar.YEAR);

        displayDate(day,month,year);

        dateDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(10);
            }
        });

    }
    void displayDate(int d, int m, int y){
        dateDialogText.setText("Date: "+d+"/"+(m+1)+"/"+y);
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id==10){
            return new DatePickerDialog(this, dateSetListener,day,month,year);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            displayDate(dayOfMonth,month,year);
        }
    };


}