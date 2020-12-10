package com.example.playing_with_dialogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements communicator{

    Button button1;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.button1);
        text=findViewById(R.id.text);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog1 myDialog= new Dialog1();
                FragmentManager manager= getSupportFragmentManager();
                myDialog.show(manager,"dialog_1");
            }
        });

    }

    @Override
    public void communicate(String string) {
        text.setText(string);
    }
}