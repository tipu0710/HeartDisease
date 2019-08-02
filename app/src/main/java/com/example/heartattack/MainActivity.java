package com.example.heartattack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity{

    static final String PREFS_NAME = "saveIt";
    private EditText nameEt, ageEt;
    private Button nextButton;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.name_et);
        ageEt = findViewById(R.id.age_et);
        radioGroup = findViewById(R.id.radio_group);
        radioButton = findViewById(R.id.male_radio);
        nextButton = findViewById(R.id.next_btn);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void createPreference(String name, int age, boolean gender) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor ed;
        if (!preferences.contains("name")){
            ed = preferences.edit();
            ed.putString("name",name);
            ed.putInt("age",age);
            ed.putBoolean("gender", gender);
            ed.apply();
        }
    }

    private void getData() {
        String name = nameEt.getText().toString();
        String age = ageEt.getText().toString();
        String gender = radioButton.getText().toString();
        boolean gen = gender.equals("Male");

        if (name.isEmpty()){
            nameEt.setError("Enter your name");
        }else if (age.isEmpty()){
            ageEt.setError("Enter your age");
        }else {
            createPreference(name,Integer.parseInt(age),gen);
            Intent intent = new Intent(MainActivity.this, NextActivity.class);
            startActivity(intent);
        }
    }

    public void RadioChecked(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }
}
