package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.mvp.presenter.LichSuPresenter;
import com.example.myapplication.activity.mvp.view.LichSuView;
import com.example.myapplication.adapter.LichSuAdapter;
import com.example.myapplication.dao.LichSuDAO;
import com.example.myapplication.model.LichSu;

import java.util.List;

public class LichSuActivity extends AppCompatActivity implements LichSuView {
    private RecyclerView rvListLS;
    private List<LichSu> lichSuList;
    private LichSuPresenter lichSuPresenter;
    private LichSuDAO lichSuDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lịch Sử");
        setContentView(R.layout.activity_lich_su);
        rvListLS = findViewById(R.id.rvLichSu);
        lichSuDAO = new LichSuDAO(this);
        lichSuPresenter = new LichSuPresenter(this);
        lichSuPresenter.showLS();
    }

    @Override
    public void show() {
        lichSuList = lichSuDAO.getAllWordLichSu();
        LichSuAdapter lichSuAdapter = new LichSuAdapter(this, lichSuList);
        if (lichSuList.size()==0){
            Toast.makeText(this, "Bạn chưa tìm kiếm từ nào trước đó", Toast.LENGTH_SHORT).show();
        }else
        rvListLS.setAdapter(lichSuAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListLS.setLayoutManager(linearLayoutManager);
    }
}
