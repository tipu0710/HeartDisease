package com.example.heartattack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.heartattack.MainActivity.PREFS_NAME;

public class FinishActivity extends AppCompatActivity {

    private TextView msgTv;
    private ModelInfo modelInfo;
    private int totalMark = 44;
    private int achiveMark = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        msgTv = findViewById(R.id.show_msg);

        modelInfo = ModelInfo.getData(this);
        if (modelInfo.isMale()){
            if (modelInfo.getAge()>45){
                achiveMark = achiveMark+1;
            }
        }else {
            if (modelInfo.getAge()>55){
                achiveMark = achiveMark+1;
            }
        }

        if (modelInfo.isSmoke()){
            achiveMark = achiveMark + 3;
        }
        if (modelInfo.isDiabetes()){
            achiveMark = achiveMark + 2;
        }
        if (modelInfo.getTotalCholesterol() == 0.0){
            totalMark = totalMark-4;
        }else {
            if (modelInfo.getAge()<=19 && modelInfo.getTotalCholesterol() > 170){
                achiveMark = achiveMark + 4;
            }else if (modelInfo.getAge()>= 20 &&
                    modelInfo.getTotalCholesterol()<125 ||
                    modelInfo.getTotalCholesterol()> 200){
                achiveMark = achiveMark + 4;
            }
        }

        if (modelInfo.getHdlCholesterol() == 0.0){
            totalMark = totalMark-4;
        }else {
            if (modelInfo.getAge()<=19 && modelInfo.getHdlCholesterol() > 45){
                achiveMark = achiveMark + 4;
            }else if (modelInfo.getAge()>= 20 &&
                    modelInfo.isMale() &&
                    modelInfo.getHdlCholesterol()>=40){
                achiveMark = achiveMark + 4;
            }else if (modelInfo.getAge()>= 20 &&
                    !modelInfo.isMale() &&
                    modelInfo.getHdlCholesterol()>=50){
                achiveMark = achiveMark + 4;
            }
        }


        if (modelInfo.getSystolicBloodPressure() == 0.0){
                    totalMark = totalMark-4;
        }else{
            if (modelInfo.getSystolicBloodPressure()<120){
                achiveMark = achiveMark + 0;
            }else if (modelInfo.getSystolicBloodPressure()>=130 && modelInfo.getSystolicBloodPressure()<= 139){
                achiveMark = achiveMark + 2;
            }else if (modelInfo.getSystolicBloodPressure()>= 140 && modelInfo.getSystolicBloodPressure()<=179){
                achiveMark = achiveMark + 3;
            }else if (modelInfo.getSystolicBloodPressure()>=180){
                achiveMark = achiveMark + 4;
            }
        }

        if (modelInfo.isHighBP()){
            achiveMark = achiveMark + 3;
        }

        if (modelInfo.isRelativeAttack()){
            achiveMark = achiveMark + 1;
        }

        if (modelInfo.isDrug()){
            achiveMark = achiveMark + 2;
        }

        if (modelInfo.isStress()){
            achiveMark = achiveMark + 3;
        }

        if (modelInfo.isHeartBurn()){
            achiveMark = achiveMark + 1;
        }

        if (modelInfo.isDizzyHeaded()){
            achiveMark = achiveMark + 1;
        }

        if (modelInfo.isShortBreath()){
            achiveMark = achiveMark + 2;
        }

        if (!modelInfo.isExercise()){
            achiveMark = achiveMark + 3;
        }

        if (modelInfo.isChestPain()){
            achiveMark = achiveMark + 5;
        }

        if (modelInfo.isChestPressure()){
            achiveMark = achiveMark + 5;
        }

        msgTv.setText("Dear "+modelInfo.getName()+"\nYou have "+(achiveMark*100)/totalMark+"% chance of heart attack!");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit().clear().apply();
        startActivity(new Intent(FinishActivity.this, MainActivity.class));
    }
}
