package com.example.workdo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView viewName, viewMatkul, viewDeadline;
    private Button buttonDetail;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        viewName = itemView.findViewById(R.id.topikText);
        viewMatkul = itemView.findViewById(R.id.matkulText);
        viewDeadline = itemView.findViewById(R.id.deadlineText);
        buttonDetail = itemView.findViewById(R.id.detailButton);
    }

    public TextView getViewTopik(){
        return viewName;
    }
    public TextView getViewMatkul(){
        return viewMatkul;
    }
    public TextView getViewDeadline(){
        return viewDeadline;
    }
    public Button getButtonDetail(){
        return buttonDetail;
    }

}
