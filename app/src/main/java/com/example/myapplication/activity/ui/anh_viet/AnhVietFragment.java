package com.example.myapplication.activity.ui.anh_viet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.myapplication.R;

public class AnhVietFragment extends Fragment {

    private SearchViewModel homeViewModel;
    private AppBarConfiguration mAppBarConfiguration;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_anhviet, container, false);
        return root;
    }
}