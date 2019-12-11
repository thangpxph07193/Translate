package com.example.myapplication.activity.mvp.presenter;

import com.example.myapplication.activity.mvp.view.VietAnhView;

public class VietAnhPresenter {
    private VietAnhView vietAnhView;

    public VietAnhPresenter(VietAnhView vietAnhView) {
        this.vietAnhView = vietAnhView;
    }
    public void search(){
        vietAnhView.searchVA();
    }
}
