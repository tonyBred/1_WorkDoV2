package com.example.workdo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormatSymbols;
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

        final Calendar cal = Calendar.getInstance();

        EditText titleText = view.findViewById(R.id.editTextTitle);
        EditText matkulText = view.findViewById(R.id.editTextMatkul);

        EditText deadlineText = view.findViewById(R.id.editTextDeadline);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(year, month, dayOfMonth);
                deadlineText.setText(cal.get(Calendar.DAY_OF_MONTH)+"-"+new DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)]+"-"+cal.get(Calendar.YEAR));
            }
        };
        deadlineText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(view.getContext(), date,
                        cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show();
            }

        });

        EditText dscText = view.findViewById(R.id.editTextDsc);

        Dummy dummy = ((MainActivity)getContext()).getDummy();
        LinkedList<Tugas> listTugas = dummy.getListTugas();

        Button button = view.findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listTugas.add(new Tugas(
                        titleText.getText().toString(),
                        matkulText.getText().toString(),
                        new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)),
                        dscText.getText().toString()
                ));

                ((MainActivity)getContext()).setDummy(dummy);

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