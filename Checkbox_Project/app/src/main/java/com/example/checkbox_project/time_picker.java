package com.example.checkbox_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

public class time_picker extends AppCompatActivity {

    TimePicker timePicker;
    TextView timeText;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

//        Referencing the views..
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        timeText=(TextView) findViewById(R.id.timeText);

        timePicker.setIs24HourView(false);

        timeText.setText("Time is: "+timePicker.getHour()+":"+timePicker.getMinute());

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeText.setText("Time is: "+hourOfDay+":"+minute);
            }
        });
    }
}