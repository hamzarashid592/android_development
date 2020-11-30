package com.example.checkbox_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.sql.Time;
import java.time.Clock;
import java.util.Calendar;

public class time_pciker_dialog extends AppCompatActivity {

    Button timePickerDialogButton;
    TextView timePickerDialogText;

    int hourOfDay,minute;
    boolean is24HourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_pciker_dialog);

//        Referencing..
        timePickerDialogText=(TextView)findViewById(R.id.timePickerDialogText);
        timePickerDialogButton=(Button)findViewById(R.id.timePickerDialogButton);

        Calendar c = Calendar.getInstance();

        hourOfDay=c.get(c.HOUR_OF_DAY);
        minute=c.get(c.MINUTE);

        timePickerDialogText.setText("Time is: "+hourOfDay+":"+minute);

        timePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(10);
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if (id==10){
            return new TimePickerDialog(this,listener,hourOfDay,minute,is24HourView);
        }
        return null;
    }
    private TimePickerDialog.OnTimeSetListener listener= new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            timePickerDialogText.setText("Time is: "+hourOfDay+":"+minute);
        }
    };
}