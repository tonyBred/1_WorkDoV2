package com.example.workdoRoom;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class TugasViewModel extends AndroidViewModel {

    private TugasRepository mRepository;

    private  LiveData<List<Tugas>> mAllTugas;
    private  LiveData<List<Tugas>> mAllTugasUpcoming;
    private  LiveData<List<Tugas>> mAllTugasOverdue;

    private LiveData<List<Tugas>> tugas;
    private Calendar now = GregorianCalendar.getInstance();

    public TugasViewModel (Application application) {
        super(application);
        mRepository = new TugasRepository(application);
        mAllTugas = mRepository.getAllTugas();
        mAllTugasUpcoming = mRepository.getAllTugasUpcoming();
        mAllTugasOverdue = mRepository.getmAllTugasOverdue();
    }

    LiveData<List<Tugas>> getAllTugas() { return mAllTugas; }
    LiveData<List<Tugas>> getAllTugasUpcoming() { return mAllTugasUpcoming; }
    LiveData<List<Tugas>> getAllTugasOverdue() { return mAllTugasOverdue; }

    public void insert(Tugas Tugas) { mRepository.insert(Tugas); }

    public void deleteAll() { mRepository.deleteAll(); }

    public LiveData<Integer> getCount(){
        return mRepository.getCount();
    }

}
