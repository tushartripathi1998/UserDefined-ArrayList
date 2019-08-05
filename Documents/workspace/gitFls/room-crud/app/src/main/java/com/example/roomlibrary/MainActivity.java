package com.example.roomlibrary;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    public static MyAppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class, "userDb").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container)!=null) {
            if (savedInstanceState != null) {
                return;
            }

            HomeFragment homeFragment = new HomeFragment();

            fragmentManager.beginTransaction().add(R.id.fragment_container, homeFragment).commit();
        }
    }
}
