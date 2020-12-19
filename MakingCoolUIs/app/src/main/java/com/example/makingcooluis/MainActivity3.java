package com.example.makingcooluis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity3 extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        navigationView=findViewById(R.id.nav_drawer);
        toolbar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);

//        Setting the created toolbar as the main action bar.
        setSupportActionBar(toolbar);
//        Making that hamburger toggle button
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState(); //Syncing rotation of toggle button with the drawer pop up.

//        Setting default fragment.
        if(savedInstanceState==null){
            navigationView.setCheckedItem(R.id.home);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FragmentA(),"fragmentA").commit();
        }


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FragmentA(),"fragmentA").commit();
                        break;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FragmentB(),"fragmentB").commit();
                        break;
                    case R.id.support:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FragmentC(),"fragmentC").commit();
                        break;
                }

                return true;
            }
        });


    }
}