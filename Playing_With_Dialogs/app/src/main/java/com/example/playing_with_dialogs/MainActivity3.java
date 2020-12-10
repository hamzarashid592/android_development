//This activity is for swipe tabs.
package com.example.playing_with_dialogs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity3 extends AppCompatActivity {

    ViewPager viewPager;
    androidx.appcompat.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //        Referencing the view pager.
        viewPager=findViewById(R.id.viewPager);

//        Making the adapter.
        myAdapter adp= new myAdapter(getSupportFragmentManager());

//        Linking the adapter to the view pager.
        viewPager.setAdapter(adp);

        Log.d("hamza","Adding action bar");

        actionBar=getSupportActionBar();
        actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_TABS);

        Log.d("hamza","Adding tabs1");


        androidx.appcompat.app.ActionBar.Tab tab1=actionBar.newTab();
        tab1.setText("TAB1");

//        ActionBar.Tab tab2=actionBar.newTab();
//        tab1.setText("TAB2");
//
//        ActionBar.Tab tab3=actionBar.newTab();
//        tab1.setText("TAB3");
//
//        Log.d("hamza","Adding tabs2");

        actionBar.addTab(tab1);
//        actionBar.addTab(tab2);
//        actionBar.addTab(tab3);




    }
}
