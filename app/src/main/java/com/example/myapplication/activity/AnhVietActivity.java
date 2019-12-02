package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.activity.MVP.AnhVietPresenter;
import com.example.myapplication.activity.MVP.AnhVietView;
import com.example.myapplication.adapter.WordAdapter;
import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.Word;

import java.util.ArrayList;
import java.util.List;

public class AnhVietActivity extends AppCompatActivity implements AnhVietView {
    private EditText editText;
    private Button btnSearchAV;
    private RecyclerView recyclerView;
    private TuDienDatabase tuDienDatabase;
    private WordAdapter wordAdapter;
    private LinearLayoutManager linearLayoutManager;
    public List<Word> wordList = new ArrayList<>();

    private AnhVietPresenter anhVietPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anh_viet);
        editText= findViewById(R.id.edtWord);
        recyclerView = findViewById(R.id.rvWord);
        tuDienDatabase = new TuDienDatabase(this);
        tuDienDatabase.createDataBase();
        btnSearchAV = findViewById(R.id.btnSearchAV);

        wordAdapter = new WordAdapter(wordList,this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(wordAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        anhVietPresenter = new AnhVietPresenter(this);

        btnSearchAV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = editText.getText().toString();
                anhVietPresenter.search(word);

            }
        });
    }


    @Override
    public void search() {

    }

    @Override
    public void checkWord() {
        editText.setError("Vui lòng nhập dữ liệu...");
    }
}
