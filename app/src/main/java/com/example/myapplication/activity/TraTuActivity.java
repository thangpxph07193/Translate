package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class TraTuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_tu);
    }

    public void VietAnh(View view) {
        Intent intent = new Intent(this, VietAnhActivity.class);
        startActivity(intent);
    }

    public void AnhViet(View view) {
        Intent intent = new Intent(this, AnhVietActivity.class);
        startActivity(intent);
    }
}
