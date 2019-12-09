package com.example.myapplication.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordHolder> {
    private TuDienDatabase tuDienDatabase;
    private List<Word> wordList;

    private Context context;

    public WordAdapter(List<Word> wordList, Context context) {
        this.wordList = wordList;
        this.context = context;
    }

    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.word,parent,false);
        return new WordHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordHolder holder, final int position) {
        final Word word = wordList.get(position);
        holder.tvWord.setText(word.word);

        holder.tvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.search_dialog);
                TextView tvWordlog =(TextView) dialog.findViewById(R.id.tvWord);
                TextView tvProce =(TextView) dialog.findViewById(R.id.tvProce);
                TextView tvDestion =(TextView) dialog.findViewById(R.id.tvDestion);

                tvWordlog.setText(word.word);
                tvDestion.setText(word.description);
                tvProce.setText(word.pronounce);


                dialog.show();
                dialog.getWindow().setLayout(1100, 900);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }
}
