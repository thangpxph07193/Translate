package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void TraTu(View view) {
        Intent intent = new Intent(this, TraTuActivity.class);
        startActivity(intent);
    }

    public void YeuThich(View view) {
        Intent intent = new Intent(this, YeuThichActivity.class);
        startActivity(intent);
    }

    public void LichSu(View view) {
        Intent intent = new Intent(this, LichSuActivity.class);
        startActivity(intent);
    }
}
