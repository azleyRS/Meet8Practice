package com.example.khomyakovruslan.meet8practice;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment1 fragment1 = new Fragment1();
        fragmentManager.beginTransaction().add(R.id.frame_container_1,fragment1).commit();
        Fragment2 fragment2 = new Fragment2();
        fragmentManager.beginTransaction().add(R.id.frame_container_2,fragment1).commit();
        Fragment3 fragment3 = new Fragment3();
        fragmentManager.beginTransaction().add(R.id.frame_container_3,fragment1).commit();
    }
}
