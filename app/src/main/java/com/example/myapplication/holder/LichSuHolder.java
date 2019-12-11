package com.example.myapplication.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class LichSuHolder extends RecyclerView.ViewHolder {
    public TextView tvWordLS;
    public TextView tvNghiaLS;
    public TextView tvPreLS;
    public ImageView imgXoaLS;

    public LichSuHolder(@NonNull View itemView) {
        super(itemView);
        tvWordLS = itemView.findViewById(R.id.tvWordLS);
        tvNghiaLS = itemView.findViewById(R.id.tvNghiaLS);
        tvPreLS = itemView.findViewById(R.id.tvPreLS);
        imgXoaLS = itemView.findViewById(R.id.imgXoaLS);
    }
}
