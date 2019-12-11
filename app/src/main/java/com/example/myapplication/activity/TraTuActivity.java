package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.activity.mvp.presenter.TraTuPresenter;
import com.example.myapplication.activity.mvp.view.TraTuView;
import com.example.myapplication.databinding.ActivityTraTuBinding;

public class TraTuActivity extends AppCompatActivity implements TraTuView {
    private TraTuPresenter traTuPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Chọn Ngôn Ngữ");
        ActivityTraTuBinding activityTraTuBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_tra_tu);
        traTuPresenter = new TraTuPresenter(this);
        activityTraTuBinding.setTraTuPresenter(traTuPresenter);
    }

    @Override
    public void vietAnh() {
        Intent intent = new Intent(this, VietAnhActivity.class);
        startActivity(intent);
    }

    @Override
    public void anhViet() {
        Intent intent = new Intent(this, AnhVietActivity.class);
        startActivity(intent);
    }
}
