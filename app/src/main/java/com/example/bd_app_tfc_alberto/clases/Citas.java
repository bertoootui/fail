package com.example.bd_app_tfc_alberto.clases;

public class Citas {

    private int id_user;
    private String date;
    private String time;

    public Citas(int id_user, String date, String time) {
        this.id_user = id_user;
        this.date = date;
        this.time = time;
    }

    public Citas(){};

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
