package com.example.playing_with_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Fragment_Communication extends AppCompatActivity implements FragmentCommunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment__communication);

        Fragment2 frag2= new Fragment2();
        Fragment3 frag3= new Fragment3();
        FragmentManager manager= getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction= manager.beginTransaction();

        transaction.replace(R.id.fragment2_layout,frag2,"fragment_2");
        transaction.replace(R.id.fragment3_layout,frag3,"fragment_3");
        transaction.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void setData(String data) {

        FragmentManager manager= getSupportFragmentManager();
        Fragment3 frag= (Fragment3) manager.findFragmentByTag("fragment_3");
        frag.modifyText(data);
    }
}