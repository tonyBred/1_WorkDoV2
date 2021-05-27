package com.example.workdoRoom;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface TugasDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Tugas tugas);

    @Query("DELETE FROM tugas_table")
    void deleteAll();

    @Query("SELECT * FROM tugas_table")
    LiveData<List<Tugas>> getAllTugas();

    @Query("SELECT * FROM tugas_table WHERE status=0")
    LiveData<List<Tugas>> getAllTugasUpcoming();

    @Query("SELECT * FROM tugas_table WHERE status=1")
    LiveData<List<Tugas>> getAllTugasOverdue();

    @Query("SELECT COUNT(*) FROM tugas_table")
    LiveData<Integer> getCount();

}
