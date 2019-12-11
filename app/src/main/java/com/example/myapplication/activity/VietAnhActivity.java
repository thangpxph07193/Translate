package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.activity.mvp.presenter.VietAnhPresenter;
import com.example.myapplication.activity.mvp.view.VietAnhView;
import com.example.myapplication.adapter.WordAdapter;
import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.LichSu;
import com.example.myapplication.model.Word;

import java.util.ArrayList;
import java.util.List;

public class VietAnhActivity extends AppCompatActivity implements VietAnhView {
    private EditText editText;
    private RecyclerView recyclerView;
    private TuDienDatabase tuDienDatabase;
    private WordAdapter wordAdapter;
    public List<Word> wordList = new ArrayList<>();
    public List<LichSu> lichSuList = new ArrayList<>();
    private VietAnhPresenter vietAnhPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viet_anh);

        editText= findViewById(R.id.edtVA);
        recyclerView = findViewById(R.id.rvVA);
        tuDienDatabase = new TuDienDatabase(this);
        tuDienDatabase.createDataBase();
        wordAdapter = new WordAdapter(wordList, this);
        vietAnhPresenter = new VietAnhPresenter(this);
        vietAnhPresenter.search();

    }

    @Override
    public void searchVA() {
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
    public void checkError() {
        editText.setError("Vui lòng nhập từ cần tra");
    }
}
