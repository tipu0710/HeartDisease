package com.example.heartattack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;

public class NextActivity extends AppCompatActivity {

    ViewPager viewPager;
    FragmentListener fragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        viewPager = findViewById(R.id.viewpager);

        fragmentListener = new FragmentListener(getSupportFragmentManager());
        viewPager.setAdapter(fragmentListener);

    }
}
