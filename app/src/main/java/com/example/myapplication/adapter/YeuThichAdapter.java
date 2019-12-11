package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.dao.YeuThichDAO;
import com.example.myapplication.holder.YeuThichHolder;
import com.example.myapplication.model.YeuThich;

import java.util.List;

public class YeuThichAdapter extends RecyclerView.Adapter<YeuThichHolder> {
    private Context context;
    private List<YeuThich> yeuThichList;
    private YeuThichDAO yeuThichDAO;

    public YeuThichAdapter(Context context, List<YeuThich> yeuThichList) {
        this.context = context;
        this.yeuThichList = yeuThichList;
    }

    @NonNull
    @Override
    public YeuThichHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yeu_thich_view,parent,false);
        YeuThichHolder yeuThichHolder = new YeuThichHolder(view);
        return yeuThichHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YeuThichHolder holder, final int position) {
        holder.tvWordYT.setText(yeuThichList.get(position).wordYT);
        holder.tvPro.setText(yeuThichList.get(position).phienAm);
        holder.tvDes.setText(yeuThichList.get(position).nghia);
        holder.imgXoaYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yeuThichDAO = new YeuThichDAO(context);
                int result = yeuThichDAO.deleteYT(yeuThichList.get(position).wordYT);
                if (result>0){
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    yeuThichList.remove(position);
                    notifyDataSetChanged();
                }
                else {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return yeuThichList.size();
    }
}
