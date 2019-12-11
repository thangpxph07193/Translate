package com.example.myapplication.activity.mvp.presenter;

import com.example.myapplication.activity.mvp.view.HomeView;

public class HomePresenter {
    private HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }
    public void search(){
        homeView.search();
    }
    public void openyeuthich(){
        homeView.yeuthich();
    }
    public void openLichSu(){
        homeView.lichsu();
    }
}
