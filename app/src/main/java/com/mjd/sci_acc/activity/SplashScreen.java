package com.mjd.sci_acc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.MainActivity;
import com.mjd.sci_acc.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Handler splashscreen = new Handler();
        splashscreen.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openactivityintent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(openactivityintent);
                finish();
            }
        }, 800);
    }
}