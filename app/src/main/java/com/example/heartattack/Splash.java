package com.example.heartattack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.icon_slaps);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(imageView, "logo");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Splash.this, pairs);
                Splash.this.startActivity(mainIntent, options.toBundle());
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
