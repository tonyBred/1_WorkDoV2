package com.example.workdoRoom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class TugasViewHolder extends RecyclerView.ViewHolder {
    private TextView viewName, viewMatkul, viewDeadline;
    private Button button;

    public TugasViewHolder(@NonNull View itemView) {
        super(itemView);
        viewName = itemView.findViewById(R.id.topikText);
        viewMatkul = itemView.findViewById(R.id.matkulText);
        viewDeadline = itemView.findViewById(R.id.deadlineText);
        button = itemView.findViewById(R.id.detailButton);
    }

    public TextView getViewTopik(){return viewName;}
    public TextView getViewMatkul(){return viewMatkul;}
    public TextView getViewDeadline(){return viewDeadline;}
    public Button getButton(){return button;}

    static TugasViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frame_textview, parent, false);
        return new TugasViewHolder(view);
    }

}
