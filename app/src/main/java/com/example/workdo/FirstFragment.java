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
        listTugas.add(new Tugas("Membuat view template", "Pengembangan Perangkat Lunak 1 Teori", "31/03/2021", "Buat view tabel mahasiswa di template"));
        listTugas.add(new Tugas("Pelajari Fragment", "Pemrograman Perangkat Begerak Praktej", "30/03/2021" , "Pelajari pragement dan implementasikan bersama recycler activity"));
        listTugas.add(new Tugas("Membuat artikel perjuangan", "Pancasilla", "05/04/2021", "Buat artikel tentang ancaman bangsa"));
        listTugas.add(new Tugas("Perbaiki ppt topik besar", "Proyek Perangkat Lunak 4", "`11/04/2021", "Perbaiki ppt dengan tambahakn hardware detail"));
        listTugas.add(new Tugas("Buat Login session pada template", "Pengembangan Perangkat Lunak 1 Praktek", "12/04/2021", "Tambah SESSION dan masukan username pada template"));
        listTugas.add(new Tugas("Cari/buat 50 data kuantitaif", "Statitiska dan Probabilitas", "12/04/2021", "Data boleh sekunder asal cantumkan referensinya"));

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