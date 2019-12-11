package com.example.myapplication.activity.mvp.presenter;

import com.example.myapplication.activity.mvp.view.LichSuView;

public class LichSuPresenter {
    private LichSuView lichSuView;

    public LichSuPresenter(LichSuView lichSuView){
        this.lichSuView = lichSuView;
    }

    public void showLS(){
        lichSuView.show();
    }
}
