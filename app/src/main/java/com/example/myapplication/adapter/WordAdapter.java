package com.example.myapplication.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.dao.LichSuDAO;
import com.example.myapplication.dao.YeuThichDAO;
import com.example.myapplication.holder.WordHolder;
import com.example.myapplication.model.LichSu;
import com.example.myapplication.model.Word;
import com.example.myapplication.model.YeuThich;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordHolder> {
    private List<Word> wordList;
    private Context context;
    private List<LichSu> lichSuList= new ArrayList<>();
    private LichSuDAO lichSuDAO;
    private List<YeuThich> yeuThichList = new ArrayList<>();
    private YeuThichDAO yeuThichDAO;

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
        lichSuDAO = new LichSuDAO(context);
        yeuThichDAO = new YeuThichDAO(context);

        holder.tvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.search_dialog);
                TextView tvWordlog =(TextView) dialog.findViewById(R.id.tvWord);
                TextView tvProce =(TextView) dialog.findViewById(R.id.tvProce);
                TextView tvDestion =(TextView) dialog.findViewById(R.id.tvDestion);
                final ImageView imgAddYT = (ImageView) dialog.findViewById(R.id.imgAddYT);

                tvWordlog.setText(word.word);
                tvDestion.setText(word.description);
                tvProce.setText(word.pronounce);
                imgAddYT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YeuThich yeuThich = new YeuThich();
                        if (yeuThichList.size()==0){
                            yeuThich.setWordYT(word.word);
                            yeuThich.setPhienAm(word.pronounce);
                            yeuThich.setNghia(word.description);
                            long result =yeuThichDAO.insertYT(yeuThich);

                            if (result > 0) {
                                Toast.makeText(context, "Bạn đã thêm thành công vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
                                int id = R.drawable.favorite;
                                imgAddYT.setImageResource(id);
                            } else {
                                Toast.makeText(context, "Từ đã có trong danh sách yêu thích", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            for (int i = 0; i<yeuThichList.size(); i++){
                                yeuThich = yeuThichList.get(i);
                                if (yeuThich.getWordYT().equalsIgnoreCase(word.word)){
                                }else {
                                    yeuThich.setWordYT(word.word);
                                    yeuThich.setPhienAm(word.pronounce);
                                    yeuThich.setNghia(word.description);
                                    yeuThichDAO.insertYT(yeuThich);

                                    long result =yeuThichDAO.insertYT(yeuThich);

                                    if (result > 0) {
                                        Toast.makeText(context, "Bạn đã thêm thành công vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
                                        int id = R.drawable.favorite;
                                        imgAddYT.setImageResource(id);
                                    } else {
                                        Toast.makeText(context, "Từ đã có trong danh sách yêu thích", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });

                LichSu lichSu = new LichSu();
                if (lichSuList.size()==0){
                    lichSu.setWordLS(word.word);
                    lichSu.setNghiaLS(word.description);
                    lichSuDAO.insertLichSu(lichSu);
                }else{
                    for (int i=0 ; i < lichSuList.size(); i++){
                        lichSu = lichSuList.get(i);
                        if (lichSu.getWordLS().equalsIgnoreCase(word.word)){

                        }else {
                            lichSu.setWordLS(word.word);
                            lichSu.setNghiaLS(word.description);
                            lichSuDAO.insertLichSu(lichSu);
                        }
                    }
                }

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
