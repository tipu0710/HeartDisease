package com.example.heartattack;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static com.example.heartattack.MainActivity.PREFS_NAME;

public class ModelInfo {
    private String name;
    private int age;
    private boolean male;
    private boolean smoke;
    private boolean diabetes;
    private double totalCholesterol;
    private double hdlCholesterol;
    private double systolicBloodPressure;
    private boolean highBP;
    private boolean relativeAttack;
    private boolean drug;
    private boolean stress;
    private boolean heartBurn;
    private boolean dizzyHeaded;
    private boolean shortBreath;
    private boolean exercise;
    private boolean chestPain;
    private boolean chestPressure;

    public ModelInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public double getTotalCholesterol() {
        return totalCholesterol;
    }

    public void setTotalCholesterol(double totalCholesterol) {
        this.totalCholesterol = totalCholesterol;
    }

    public double getHdlCholesterol() {
        return hdlCholesterol;
    }

    public void setHdlCholesterol(double hdlCholesterol) {
        this.hdlCholesterol = hdlCholesterol;
    }

    public double getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(double systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public boolean isHighBP() {
        return highBP;
    }

    public void setHighBP(boolean highBP) {
        this.highBP = highBP;
    }

    public boolean isRelativeAttack() {
        return relativeAttack;
    }

    public void setRelativeAttack(boolean relativeAttack) {
        this.relativeAttack = relativeAttack;
    }

    public boolean isDrug() {
        return drug;
    }

    public void setDrug(boolean drug) {
        this.drug = drug;
    }

    public boolean isStress() {
        return stress;
    }

    public void setStress(boolean stress) {
        this.stress = stress;
    }

    public boolean isHeartBurn() {
        return heartBurn;
    }

    public void setHeartBurn(boolean heartBurn) {
        this.heartBurn = heartBurn;
    }

    public boolean isDizzyHeaded() {
        return dizzyHeaded;
    }

    public void setDizzyHeaded(boolean dizzyHeaded) {
        this.dizzyHeaded = dizzyHeaded;
    }

    public boolean isShortBreath() {
        return shortBreath;
    }

    public void setShortBreath(boolean shortBreath) {
        this.shortBreath = shortBreath;
    }

    public boolean isExercise() {
        return exercise;
    }

    public void setExercise(boolean exercise) {
        this.exercise = exercise;
    }

    public boolean isChestPain() {
        return chestPain;
    }

    public void setChestPain(boolean chestPain) {
        this.chestPain = chestPain;
    }

    public boolean isChestPressure() {
        return chestPressure;
    }

    public void setChestPressure(boolean chestPressure) {
        this.chestPressure = chestPressure;
    }

    public static ModelInfo getData(Context context){
        ModelInfo modelInfo = new ModelInfo();
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        modelInfo.setName(prefs.getString("name","Unknown"));
        modelInfo.setAge(prefs.getInt("age",20));
        modelInfo.setMale(prefs.getBoolean("gender", true));
        modelInfo.setSmoke(prefs.getBoolean("smoke",false));
        modelInfo.setDiabetes(prefs.getBoolean("diabetes", false));
        modelInfo.setHighBP(prefs.getBoolean("highBP",false));
        modelInfo.setRelativeAttack(prefs.getBoolean("relativeAttack",false));
        modelInfo.setDrug(prefs.getBoolean("drug",false));
        modelInfo.setStress(prefs.getBoolean("stress",false));
        modelInfo.setHeartBurn(prefs.getBoolean("heartBurn",false));
        modelInfo.setDizzyHeaded(prefs.getBoolean("dizzyHeaded",false));
        modelInfo.setShortBreath(prefs.getBoolean("shortBreath",false));
        modelInfo.setExercise(prefs.getBoolean("exercise",false));
        modelInfo.setChestPain(prefs.getBoolean("chestPain",false));
        modelInfo.setChestPressure(prefs.getBoolean("chestPressure",false));
        modelInfo.setTotalCholesterol(prefs.getFloat("totalChol",0.0f));
        modelInfo.setHdlCholesterol(prefs.getFloat("HdlChol", 0.0f));
        modelInfo.setSystolicBloodPressure(prefs.getFloat("SystolicBP", 0.0f));
        return modelInfo;
    }
}
