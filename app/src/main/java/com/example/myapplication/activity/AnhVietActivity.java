package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.adapter.WordAdapter;
import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.Word;

import java.util.ArrayList;
import java.util.List;

public class AnhVietActivity extends AppCompatActivity {
    private EditText editText;
    private RecyclerView recyclerView;
    private TuDienDatabase tuDienDatabase;
    private WordAdapter wordAdapter;
    private LinearLayoutManager linearLayoutManager;
    public List<Word> wordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anh_viet);
        editText= findViewById(R.id.edtWord);
        recyclerView = findViewById(R.id.rvWord);
        tuDienDatabase = new TuDienDatabase(this);
        tuDienDatabase.createDataBase();

        wordAdapter = new WordAdapter(wordList,this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(wordAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void search(View view) {
        String word= editText.getText().toString().trim();

        if (word.isEmpty()){
            editText.setError("Vui lòng nhập dữ liệu....");
            return;
        }else{
            List<Word> wordList = tuDienDatabase.searchWord(word);
            this.wordList.addAll(wordList);
            wordAdapter.notifyDataSetChanged();
        }
    }
}
