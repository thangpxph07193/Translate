package com.example.myapplication.activity.MVP;

import com.example.myapplication.activity.AnhVietActivity;
import com.example.myapplication.adapter.WordAdapter;
import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.Word;

import java.util.ArrayList;
import java.util.List;

public class AnhVietPresenter {
    private AnhVietActivity anhVietActivity;
    private TuDienDatabase tuDienDatabase;
    private WordAdapter wordAdapter;
    private AnhVietView anhVietView;
    public List<Word> wordList = new ArrayList<>();
    public AnhVietPresenter(AnhVietView anhVietView){
        this.anhVietView=anhVietView;

    }


    public void search(String word){
        anhVietActivity = new AnhVietActivity();
        tuDienDatabase = new TuDienDatabase(anhVietActivity);
        wordAdapter = new WordAdapter(wordList, anhVietActivity);
        if (word.isEmpty()){
            anhVietView.checkWord();
            return;
        }else {
            List<Word> wordList = tuDienDatabase.searchWord(word);
            this.anhVietActivity.wordList.addAll(wordList);
            wordAdapter.notifyDataSetChanged();
        }
    }

}