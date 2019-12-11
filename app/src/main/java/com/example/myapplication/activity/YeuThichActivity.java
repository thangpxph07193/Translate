package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.activity.mvp.presenter.YeuThichPresenter;
import com.example.myapplication.activity.mvp.view.YeuThichView;
import com.example.myapplication.adapter.YeuThichAdapter;
import com.example.myapplication.dao.YeuThichDAO;
import com.example.myapplication.model.YeuThich;

import java.util.List;

public class YeuThichActivity extends AppCompatActivity implements YeuThichView {
    private RecyclerView rvYeuThich;
    private List<YeuThich> yeuThichList;
    private YeuThichDAO yeuThichDAO;
    private YeuThichPresenter yeuThichPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeu_thich);
        rvYeuThich = findViewById(R.id.rvYeuThich);
        yeuThichDAO = new YeuThichDAO(this);
        yeuThichPresenter = new YeuThichPresenter(this);
        yeuThichPresenter.show();
    }

    @Override
    public void showYT() {
        yeuThichList = yeuThichDAO.getAllWordYT();
        YeuThichAdapter yeuThichAdapter = new YeuThichAdapter(this, yeuThichList);
        rvYeuThich.setAdapter(yeuThichAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvYeuThich.setLayoutManager(linearLayoutManager);

        Log.e("ABC", yeuThichList.size()+"");
    }
}
