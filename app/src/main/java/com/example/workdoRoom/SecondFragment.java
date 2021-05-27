package com.example.workdoRoom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class SecondFragment extends Fragment {

    private RecyclerView recyclerView;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private TugasViewModel mTugasViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        try{
            mTugasViewModel = ((MainActivity)getActivity()).tugasViewModel;
        }catch (NullPointerException ex){
            ex.getMessage();
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewsecond);
        final TugasListAdapter adapter = new TugasListAdapter(new TugasListAdapter.TugasDiff());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        try{
            mTugasViewModel.getAllTugasOverdue().observe(this.getActivity(), words -> {
                // Update the cached copy of the words in the adapter.
                adapter.submitList(words);
            });
        }catch(NullPointerException ex){
            ex.getMessage();
        }

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}