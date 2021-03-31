package com.example.workdo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;

class StringAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private LinkedList<Tugas> list = new LinkedList<Tugas>();
    private int index = 0;

    public StringAdapter(LinkedList listTugas) {
        this.list = listTugas;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.frame_textview;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getViewTopik().setText(list.get(position).getTopik());
        holder.getViewMatkul().setText(list.get(position).getMatkul());
        holder.getViewDeadline().setText(list.get(position).getDeadline());
        holder.getButtonDetail();
        holder.getButtonDetail().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayDetailActivity.class);
                intent.putExtra("Judul", list.get(position).getTopik());
                intent.putExtra("Matkul", list.get(position).getMatkul());
                intent.putExtra("Deadline", list.get(position).getDeadline());
                intent.putExtra("Desc", list.get(position).getDesc());
                v.getContext().startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}