package com.example.myapplication.activity.mvp.presenter;

import com.example.myapplication.activity.mvp.view.YeuThichView;

public class YeuThichPresenter {
    private YeuThichView yeuThichView;

    public YeuThichPresenter(YeuThichView yeuThichView) {
        this.yeuThichView = yeuThichView;
    }
    public void show(){
        yeuThichView.showYT();
    }
}
