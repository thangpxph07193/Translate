package com.example.myapplication.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class YeuThichHolder extends RecyclerView.ViewHolder {
    public TextView tvWordYT;
    public TextView tvPro;
    public TextView tvDes;
    public ImageView imgXoaYT;

    public YeuThichHolder(@NonNull View itemView) {
        super(itemView);
        tvWordYT = itemView.findViewById(R.id.tvWordYT);
        tvPro = itemView.findViewById(R.id.tvPro);
        tvDes = itemView.findViewById(R.id.tvDes);
        imgXoaYT = itemView.findViewById(R.id.imgXoaYT);
    }
}
