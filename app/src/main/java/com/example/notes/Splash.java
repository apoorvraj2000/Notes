package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    private  static  int splash_timeout=4000;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home=new Intent(Splash.this,MainActivity.class);
                startActivity(home);
                finish();
            }
        },splash_timeout);
    }
}