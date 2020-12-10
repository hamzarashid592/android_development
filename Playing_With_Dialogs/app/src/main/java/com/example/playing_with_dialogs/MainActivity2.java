//This activity is for scrollable tabs.
package com.example.playing_with_dialogs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        Referencing the view pager.
        viewPager=findViewById(R.id.viewPager);

//        Making the adapter.
        myAdapter adp= new myAdapter(getSupportFragmentManager());

//        Linking the adapter to the view pager.
        viewPager.setAdapter(adp);


    }
}

class myAdapter extends FragmentPagerAdapter {

    Fragment fragment;

    public myAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            fragment = new FragmentA();
        } else if (position == 1) {
            fragment = new FragmentB();
        } else if (position == 2) {
            fragment = new FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return ("TAB 01");
        } else if (position == 1) {
            return ("TAB 02");
        } else if (position == 2) {
            return ("TAB 03");
        }
        return null;
    }
}