package com.example.shashidhar.mytimetable;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout = (TabLayout) findViewById(R.id.tabModeID);
        viewPager  = (ViewPager) findViewById(R.id.viewpagerID);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //fragments:

        adapter.AddFragment(new mondayFragment(), "Monday");
        adapter.AddFragment(new tuesdayFragment(), "Tuesday");
        adapter.AddFragment(new wednesdayFragment(), "Wednesday");
        adapter.AddFragment(new thursdayFragment(), "Thursday");
        adapter.AddFragment(new fridayFragment(), "Friday");
        adapter.AddFragment(new saturdayFragment(), "Saturday");
        adapter.AddFragment(new sundayFragment(), "Sunday");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
