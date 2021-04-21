package com.example.workdo;

import java.util.Calendar;
import java.util.Date;

public class Tugas {
    private String topik;
    private String matkul;
    private Calendar deadline;
    private String desc;

    public Tugas(String topik, String matkul, Calendar deadline, String desc){
        this.topik = topik;
        this.matkul = matkul;
        this.deadline = deadline;
        this.desc = desc;
    }

    public String getTopik(){
        return topik;
    }

    public String getMatkul(){
        return matkul;
    }

    public Calendar getDeadline(){
        return deadline;
    }

    public String getDesc(){
        return desc;
    }

}
