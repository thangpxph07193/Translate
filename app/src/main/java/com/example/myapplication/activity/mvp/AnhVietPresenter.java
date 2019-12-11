package com.example.myapplication.activity.mvp;

import com.example.myapplication.activity.mvp.view.AnhVietView;


public class AnhVietPresenter {
    private AnhVietView anhVietView;


    public AnhVietPresenter(AnhVietView anhVietView){
        this.anhVietView=anhVietView;

    }

    public void search() {
        anhVietView.searchAV();
    }


}