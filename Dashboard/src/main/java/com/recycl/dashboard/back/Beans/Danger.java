package com.recycl.dashboard.back.Beans;

public class Danger {
    private int Id;
    private String Niveau;

    public Danger(int id, String niveau) {
        Id = id;
        Niveau = niveau;
    }

    public Danger() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
    }
}
