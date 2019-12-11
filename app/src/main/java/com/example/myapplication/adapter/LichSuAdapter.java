package com.example.myapplication.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.dao.LichSuDAO;
import com.example.myapplication.holder.LichSuHolder;
import com.example.myapplication.model.LichSu;

import java.util.List;

public class LichSuAdapter extends RecyclerView.Adapter<LichSuHolder> {
    private Context context;
    private List<LichSu> lichSuList;
    private LichSuDAO lichSuDAO;

    public LichSuAdapter(Context context, List<LichSu> lichSuList) {
        this.context = context;
        this.lichSuList = lichSuList;
    }

    @NonNull
    @Override
    public LichSuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lich_su_view, parent,false);
        LichSuHolder lichSuHolder = new LichSuHolder(view);
        return lichSuHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LichSuHolder holder, final int position) {
        holder.tvWordLS.setText(lichSuList.get(position).wordLS);
        holder.tvNghiaLS.setText(lichSuList.get(position).nghiaLS);
        holder.tvPreLS.setText(lichSuList.get(position).phienAmLS);
        holder.imgXoaLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lichSuDAO = new LichSuDAO(context);
                int result = lichSuDAO.deleteLichSu(lichSuList.get(position).wordLS);
                if (result>0){
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    lichSuList.remove(position);
                    notifyDataSetChanged();
                }else{
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return lichSuList.size();
    }
}
