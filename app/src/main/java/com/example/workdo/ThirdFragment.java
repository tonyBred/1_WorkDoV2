package com.example.workdo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

public class ThirdFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        EditText titleText = view.findViewById(R.id.editTextTitle);
        EditText matkulText = view.findViewById(R.id.editTextMatkul);
        EditText deadlineText = view.findViewById(R.id.editTextDeadline);
        EditText dscText = view.findViewById(R.id.editTextDsc);

        Dummy dummy = new Dummy();
        LinkedList<Tugas> listTugas = dummy.getListTugas();

        Button button = view.findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listTugas.add(new Tugas(
                        titleText.getText().toString(),
                        matkulText.getText().toString(),
                        new GregorianCalendar(2021, 3-1, 25),
                        dscText.getText().toString()
                ));

                dummy.setListTugas(listTugas);

                titleText.setText("");
                matkulText.setText("");
                deadlineText.setText("");
                dscText.setText("");

                Toast.makeText(getActivity().getApplicationContext(),"Added new Work",Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}