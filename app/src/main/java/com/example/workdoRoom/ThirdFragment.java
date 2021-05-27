package com.example.workdoRoom;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.google.android.material.tabs.TabLayout;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import static android.app.Activity.RESULT_OK;
import static java.sql.DriverManager.println;

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

        EditText deadlineDateText = view.findViewById(R.id.editTextDeadlineDate);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(year, month, dayOfMonth);
                deadlineDateText.setText(cal.get(Calendar.DAY_OF_MONTH)+"-"+new DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)]+"-"+cal.get(Calendar.YEAR));
            }
        };
        deadlineDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(view.getContext(), date,
                        cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        EditText deadlineTimeText = view.findViewById(R.id.editTextDeadlineTime);
        TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, minute);
                deadlineTimeText.setText(cal.get(Calendar.HOUR_OF_DAY)+"."+cal.get(Calendar.MINUTE));
            }
        };
        deadlineTimeText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new TimePickerDialog(view.getContext(), time,
                        cal.get(Calendar.HOUR_OF_DAY),
                        cal.get(Calendar.MINUTE), true).show();
            }
        });

        EditText dscText = view.findViewById(R.id.editTextDsc);


        Button button = view.findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Tugas tugas = new Tugas(titleText.getText().toString(),
                        matkulText.getText().toString(),
                        new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), 00).getTimeInMillis(),
                        dscText.getText().toString(), (cal.compareTo(GregorianCalendar.getInstance()) > 0) ? 0 : 1);

                try{
                    ((MainActivity)getActivity()).tugasViewModel.insert(tugas);
                    ((MainActivity)getActivity()).tugasViewModel.getCount().observe(getActivity(), new Observer<Integer>() {
                        @Override
                        public void onChanged(Integer integer) {
                            Log.i("DEBUG_TAG", String.valueOf(integer));
                        }
                    });
                }catch (NullPointerException ex){
                    ex.getMessage();
                }

                titleText.setText("");
                matkulText.setText("");
                deadlineDateText.setText("");
                deadlineTimeText.setText("");
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