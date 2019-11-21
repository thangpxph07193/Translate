package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Thread bamgio = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (Exception e) {

                }
                finally {
                    Intent intent = new Intent("com.example.myapplication.activity.HomeActivity");
                    startActivity(intent);
                }
            }
        };
        bamgio.start();

    }protected void onPause(){
        super.onPause();
        finish();
    }
}
