package com.example.workdo;

public class Tugas {
    private String topik;
    private String matkul;
    private String deadline;
    private String desc;

    public Tugas(String topik, String matkul, String deadline, String desc){
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

    public String getDeadline(){
        return deadline;
    }

    public String getDesc(){
        return desc;
    }

}
