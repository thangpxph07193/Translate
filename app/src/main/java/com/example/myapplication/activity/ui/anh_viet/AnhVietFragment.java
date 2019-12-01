package com.example.myapplication.activity.ui.anh_viet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.WordAdapter;
import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.Word;

import java.util.ArrayList;
import java.util.List;

public class AnhVietFragment extends Fragment implements AnhVietView {
    private EditText editText;
    private RecyclerView rvList;
    private TuDienDatabase tuDienDatabase;
    private WordAdapter wordAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<Word> wordList = new ArrayList<>();


    private AppBarConfiguration mAppBarConfiguration;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_anhviet, container, false);

        editText = root.findViewById(R.id.edtWord);
        rvList = root.findViewById(R.id.rvList);


        return root;
    }
}