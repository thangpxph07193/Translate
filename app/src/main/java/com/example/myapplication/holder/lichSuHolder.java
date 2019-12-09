package com.example.myapplication.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class lichSuHolder extends RecyclerView.ViewHolder {
    public TextView tvWordLS;
    public TextView tvNghiaLS;

    public lichSuHolder(@NonNull View itemView) {
        super(itemView);
        tvWordLS = itemView.findViewById(R.id.tvWordLS);
        tvNghiaLS = itemView.findViewById(R.id.tvNghiaLS);
    }
}
