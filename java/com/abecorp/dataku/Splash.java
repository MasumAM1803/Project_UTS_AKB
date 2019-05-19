package com.abecorp.dataku;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int SPLASH_TIME_OUT = 600;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(loginIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
