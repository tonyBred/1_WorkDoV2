package com.example.workdoRoom;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName = "tugas_table")
public class Tugas {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tugas")
    private String topik;

    @NonNull
    private String matkul;

    @NonNull
    private long deadline;

    @NonNull
    private String desc;

    @NonNull
    @ColumnInfo(name = "status")
    private int status;

    public Tugas(@NonNull String topik, @NonNull String matkul, @NonNull long deadline, @NonNull String desc, @NonNull int status){
        this.topik = topik;
        this.matkul = matkul;
        this.deadline = deadline;
        this.desc = desc;
        this.status = status;
    }

    public String getTopik(){
        return topik;
    }

    public String getMatkul(){
        return matkul;
    }

    public long getDeadline(){
        return deadline;
    }

    public String getDesc(){
        return desc;
    }

    public int getStatus(){return status;}

}
