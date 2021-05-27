package com.example.workdoRoom;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class TugasRepository {

    private TugasDao mTugasDao;
    private LiveData<List<Tugas>> mAllTugas;
    private LiveData<List<Tugas>> mAllTugasUpcoming;
    private LiveData<List<Tugas>> mAllTugasOverdue;

    // Note that in order to unit test the TugasRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    TugasRepository(Application application) {
        TugasRoomDatabase db = TugasRoomDatabase.getDatabase(application);
        mTugasDao = db.tugasDao();
        mAllTugas = mTugasDao.getAllTugas();
        mAllTugasUpcoming = mTugasDao.getAllTugasUpcoming();
        mAllTugasOverdue = mTugasDao.getAllTugasOverdue();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Tugas>> getAllTugas() {
        return mAllTugas;
    }
    LiveData<List<Tugas>> getAllTugasUpcoming() {
        return mAllTugasUpcoming;
    }
    LiveData<List<Tugas>> getmAllTugasOverdue() {
        return mAllTugasOverdue;
    }

    public LiveData<Integer> getCount(){
        return mTugasDao.getCount();
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Tugas tugas) {
        TugasRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTugasDao.insert(tugas);
        });
    }

    void deleteAll() {
        TugasRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTugasDao.deleteAll();
        });
    }

}
