package com.example.workdo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class SecondFragment extends Fragment {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Dummy dummy = ((MainActivity)getContext()).getDummy();
        LinkedList<Tugas> listTugas = new LinkedList<Tugas>();

        Calendar cal = GregorianCalendar.getInstance();

        for(int i=0; i<dummy.getListTugas().size();i++){
            if(dummy.getListTugas().get(i).getDeadline().getTime().before(cal.getTime())){
                listTugas.add(dummy.getListTugas().get(i));
            }
        }

        recyclerView = view.findViewById(R.id.recyclerviewsecond);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new StringAdapterSecond(listTugas));

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}