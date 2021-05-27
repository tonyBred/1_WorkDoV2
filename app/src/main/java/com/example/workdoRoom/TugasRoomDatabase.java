package com.example.workdoRoom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.*;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Tugas.class}, version = 1, exportSchema = false)
public abstract class TugasRoomDatabase extends RoomDatabase {

    public abstract TugasDao tugasDao();

    private static volatile TugasRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TugasRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TugasRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TugasRoomDatabase.class, "tugas_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more Tugass, just add them.
                TugasDao dao = INSTANCE.tugasDao();
                dao.deleteAll();
            });
        }
    };

}
