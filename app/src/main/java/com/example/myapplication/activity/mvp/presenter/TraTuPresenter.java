package com.example.myapplication.activity.mvp.presenter;

import com.example.myapplication.activity.mvp.view.TraTuView;

public class TraTuPresenter {
    private TraTuView traTuView;

    public TraTuPresenter(TraTuView traTuView) {
        this.traTuView = traTuView;
    }
    public void searchVietAnh(){
        traTuView.vietAnh();
    }
    public void searchAnhViet(){
        traTuView.anhViet();
    }
}
