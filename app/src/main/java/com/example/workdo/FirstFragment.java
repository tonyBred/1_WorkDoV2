package com.example.workdo;

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

import java.util.LinkedList;
import java.util.List;

public class FirstFragment extends Fragment {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        //Hardcode data
        LinkedList<Tugas> listTugas = new LinkedList<Tugas>();
        listTugas.add(new Tugas("Membuat view template", "Pengembangan Perangkat Lunak 1", "31/03/2021", "Buat view tabel mahasiswa di template"));
        listTugas.add(new Tugas("Pelajari Fragment", "Pemrograman Perangkat Begerak", "30/03/2021" , "Pelajari pragement dan implementasikan bersama recycler activity"));
        listTugas.add(new Tugas("Membuat artikel perjuangan", "Pancasilla", "05/04/2021", "Buat artikel tentang ancaman bangsa"));

        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new StringAdapter(listTugas));

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}