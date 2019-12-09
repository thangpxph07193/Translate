package com.example.myapplication.activity.mvp;

import android.content.Context;
import android.widget.EditText;

import com.example.myapplication.activity.AnhVietActivity;



public class AnhVietPresenter {
    private AnhVietView anhVietView;


    public AnhVietPresenter(AnhVietView anhVietView){
        this.anhVietView=anhVietView;

    }

    public void search() {
        anhVietView.searchAV();
    }
    public void getDataPt(){
        anhVietView.getData();
    }


}