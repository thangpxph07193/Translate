package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.mvp.AnhVietPresenter;
import com.example.myapplication.activity.mvp.AnhVietView;
import com.example.myapplication.adapter.WordAdapter;
import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.databinding.ActivityAnhVietBinding;
import com.example.myapplication.model.LichSu;
import com.example.myapplication.model.Word;

import java.util.ArrayList;
import java.util.List;

public class AnhVietActivity extends AppCompatActivity implements AnhVietView {
    private EditText editText;
    private RecyclerView recyclerView;
    private TuDienDatabase tuDienDatabase;
    private WordAdapter wordAdapter;
    public List<Word> wordList = new ArrayList<>();
    public List<LichSu>lichSuList = new ArrayList<>();

    private AnhVietPresenter anhVietPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAnhVietBinding activityAnhVietBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_anh_viet);
        anhVietPresenter = new AnhVietPresenter(this);
        activityAnhVietBinding.setAnhVietPresenter(anhVietPresenter);
        editText= findViewById(R.id.edtWord);
        recyclerView = findViewById(R.id.rvWord);
        tuDienDatabase = new TuDienDatabase(this);
        tuDienDatabase.createDataBase();

        wordAdapter = new WordAdapter(wordList,this);
        anhVietPresenter.search();
        anhVietPresenter.getDataPt();



    }


    @Override
    public void searchAV() {
        String word = editText.getText().toString().trim();
        if (word.isEmpty()){
            checkError();
        }else{
            LichSu lichSu = new LichSu();
            if (lichSuList.size()==0){
                lichSu.setWordLS(word);
            }


            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(wordAdapter);
            List<Word> wordList = tuDienDatabase.searchWord(word);
            this.wordList.addAll(wordList);
            wordAdapter.notifyDataSetChanged();
        }


    }

    @Override
    public void getData() {

    }

    @Override
    public void checkError() {
        editText.setError("Vui lòng nhập từ cần tra");
    }
}
