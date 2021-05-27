package com.example.workdoRoom;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class TugasListAdapter extends ListAdapter<Tugas, TugasViewHolder> {

    public TugasListAdapter(@NonNull DiffUtil.ItemCallback<Tugas> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TugasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TugasViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TugasViewHolder holder, int position) {

        Tugas current = getItem(position);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(current.getDeadline());

        String tgl = cal.get(Calendar.DAY_OF_MONTH)+"-"
                +new DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)]+"-"
                +cal.get(Calendar.YEAR);

        String hour = "null";
        if(cal.get(Calendar.HOUR_OF_DAY) < 10){
            hour = "0"+cal.get(Calendar.HOUR_OF_DAY);
        }else{
            hour = ""+cal.get(Calendar.HOUR_OF_DAY);
        }

        String minute = "null";
        if(cal.get(Calendar.MINUTE) < 10){
            minute = "0"+cal.get(Calendar.MINUTE);
        }else{
            minute = ""+cal.get(Calendar.MINUTE);
        }

        String tglWithHour = cal.get(Calendar.DAY_OF_MONTH)+"-"
                +new DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)]+"-"
                +cal.get(Calendar.YEAR)+" Pukul: "
                +hour+"."
                +minute;

        try{
            holder.getViewTopik().setText(current.getTopik());
            holder.getViewMatkul().setText(current.getMatkul());
            holder.getViewDeadline().setText(tgl);
            holder.getButton();
            holder.getButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DisplayDetailActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("Judul", current.getTopik());
                    bundle.putString("Matkul", current.getMatkul());
                    bundle.putString("Deadline", tglWithHour);
                    bundle.putString("Desc", current.getDesc());

                    intent.putExtras(bundle);

                    v.getContext().startActivities(new Intent[]{intent});
                }
            });
        }catch(NullPointerException ex){
            ex.getMessage();
        }
    }

    static class TugasDiff extends DiffUtil.ItemCallback<Tugas> {

        @Override
        public boolean areItemsTheSame(@NonNull Tugas oldItem, @NonNull Tugas newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tugas oldItem, @NonNull Tugas newItem) {
            return false;
        }
    }
}