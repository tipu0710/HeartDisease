package com.example.heartattack.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heartattack.FinishActivity;
import com.example.heartattack.ModelInfo;
import com.example.heartattack.R;

public class QuestionFragment extends Fragment {
    private static final String PREFS_NAME = "saveIt";
    private ModelInfo modelInfo = new ModelInfo();
    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final int position = getArguments().getInt("position");
        SharedPreferences preferences = getContext().getSharedPreferences(PREFS_NAME, getContext().MODE_PRIVATE);
        final SharedPreferences.Editor ed;
        ed = preferences.edit();

        View view= inflater.inflate(R.layout.fragment_question, container, false);
        TextView tv = view.findViewById(R.id.tv);
        RadioGroup radioGroup = view.findViewById(R.id.radio_group1);
        ImageView imageView = view.findViewById(R.id.image_view);
        final ViewPager viewPager = getActivity().findViewById(R.id.viewpager);
        final EditText editText = view.findViewById(R.id.et);
        Button button = view.findViewById(R.id.next_btn_);
        Button buttonPre = view.findViewById(R.id.pre_btn_);

        final RadioButton radioButton1 = view.findViewById(R.id.radio1);
        final RadioButton radioButton2 = view.findViewById(R.id.radio2);

        radioButton1.setText("YES");
        radioButton2.setText("NO");

        buttonPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(position-2,true);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioButton1.isChecked()){
                    if (position==1){
                        ed.putBoolean("smoke",true);
                    }else if (position==2){
                        ed.putBoolean("diabetes",true);
                    }else if (position==6){
                        ed.putBoolean("highBP", true);
                    }else if (position==7){
                        ed.putBoolean("relativeAttack", true);
                    }else if (position==8){
                        ed.putBoolean("drug", true);
                    }else if (position==9){
                        ed.putBoolean("stress", true);
                    }else if (position==10){
                        ed.putBoolean("heartBurn", true);
                    }else if (position==11){
                        ed.putBoolean("dizzyHeaded", true);
                    }else if (position==12){
                        ed.putBoolean("shortBreath", true);
                    }else if (position==13){
                        ed.putBoolean("exercise", true);
                    }else if (position==14){
                        ed.putBoolean("chestPain", true);
                    }else if (position==15){
                        ed.putBoolean("chestPressure", true);
                        startActivity(new Intent(getContext(), FinishActivity.class));
                    }
                }else {
                    if (position==1){
                        ed.putBoolean("smoke",false);
                    }else if (position==2){
                        ed.putBoolean("diabetes",false);
                    }else if (position==6){
                        ed.putBoolean("highBP", false);
                    }else if (position==7){
                        ed.putBoolean("relativeAttack", false);
                    }else if (position==8){
                        ed.putBoolean("drug", false);
                    }else if (position==9){
                        ed.putBoolean("stress", false);
                    }else if (position==10){
                        ed.putBoolean("heartBurn", false);
                    }else if (position==11){
                        ed.putBoolean("dizzyHeaded", false);
                    }else if (position==12){
                        ed.putBoolean("shortBreath", false);
                    }else if (position==13){
                        ed.putBoolean("exercise", false);
                    }else if (position==14){
                        ed.putBoolean("chestPain", false);
                    }else if (position==15){
                        ed.putBoolean("chestPressure", false);
                        startActivity(new Intent(getContext(), FinishActivity.class));
                    }
                }

                if (position==3){
                    String s = editText.getText().toString();
                    if (s.isEmpty()){
                        ed.putFloat("totalChol",0.0f);
                    }else {
                        ed.putFloat("totalChol",Float.parseFloat(s));
                    }
                }else if (position==4){
                    String s = editText.getText().toString();
                    if (s.isEmpty()){
                        ed.putFloat("HdlChol",0.0f);
                    }else {
                        ed.putFloat("HdlChol",Float.parseFloat(s));
                    }
                }else if (position==5){
                    String s = editText.getText().toString();
                    if (s.isEmpty()){
                        ed.putFloat("SystolicBP",0.0f);
                    }else {
                        ed.putFloat("SystolicBP",Float.parseFloat(s));
                    }
                }
                ed.apply();
                viewPager.setCurrentItem(position,true);
            }
        });

        if (position==1){
            imageView.setBackgroundResource(R.drawable.smoking);
            tv.setText("Do you smoke?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
            buttonPre.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);
        }else if (position == 2){
            imageView.setBackgroundResource(R.drawable.diabetes);
            tv.setText("Do you have diabetes?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
            buttonPre.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
        }else if (position == 3){
            imageView.setBackgroundResource(R.drawable.ic_cholesterol);
            tv.setText("Total Cholesterol");
            radioGroup.setVisibility(View.GONE);
            editText.setVisibility(View.VISIBLE);
        }else if (position == 4){
            imageView.setBackgroundResource(R.drawable.ic_cholesterol);
            tv.setText("HDL Cholesterol");
            radioGroup.setVisibility(View.GONE);
            editText.setVisibility(View.VISIBLE);
        }else if (position == 5){
            imageView.setBackgroundResource(R.drawable.pulse);
            tv.setText("Systolic blood pressure");
            radioGroup.setVisibility(View.GONE);
            editText.setVisibility(View.VISIBLE);
        }else if (position == 6) {
            imageView.setBackgroundResource(R.drawable.hypertension);
            tv.setText("Treated for high blood pressure?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 7) {
            imageView.setBackgroundResource(R.drawable.ic_family);
            tv.setText("Do your father or mother have heart attack \nbefore age 60?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 8) {
            imageView.setBackgroundResource(R.drawable.syringe);
            tv.setText("Do you take any kind of drug?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 9) {
            imageView.setBackgroundResource(R.drawable.headache);
            tv.setText("Do you feel any kind of stress?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 10) {
            imageView.setBackgroundResource(R.drawable.aed);
            tv.setText("Do you feel heart burn?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 11) {
            imageView.setBackgroundResource(R.drawable.stress);
            tv.setText("Do you feel dizzy or light headache?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 12) {
            imageView.setBackgroundResource(R.drawable.smelling);
            tv.setText("Do you have shortness of breath?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 13) {
            imageView.setBackgroundResource(R.drawable.exercise);
            tv.setText("Do you take regular exercise?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 14) {
            imageView.setBackgroundResource(R.drawable.chest);
            tv.setText("Do you feel any pain in \nyour chest?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
        }else if (position == 15) {
            imageView.setBackgroundResource(R.drawable.torso);
            tv.setText("Do you feel any pressure, pain or\nin your chest that may spread neck, \njaw or shoulder or one or \nboth hands?");
            radioGroup.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
            buttonPre.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            button.setText("FINISH");
        }

        return view;
    }



}
