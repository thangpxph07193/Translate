package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.activity.mvp.presenter.HomePresenter;
import com.example.myapplication.activity.mvp.view.HomeView;
import com.example.myapplication.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Translate");
        ActivityHomeBinding activityHomeBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_home);
        homePresenter = new HomePresenter(this);
        activityHomeBinding.setHome(homePresenter);

    }


    @Override
    public void search() {
        Intent intent = new Intent(this, TraTuActivity.class);
        startActivity(intent);
    }

    @Override
    public void yeuthich() {
        Intent intent = new Intent(this, YeuThichActivity.class);
        startActivity(intent);
    }

    @Override
    public void lichsu() {
        Intent intent = new Intent(this, LichSuActivity.class);
        startActivity(intent);
    }
}
