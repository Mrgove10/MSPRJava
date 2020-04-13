package com.recycl.dashboard.back.Beans;

public class Site {
    private int Id;
    private Adresse Adresse;
    private String Nom;

    public Site(int id, Adresse adresse, String nom) {
        Id = id;
        Adresse = adresse;
        Nom = nom;
    }

    public Site() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Adresse getAdresse() {
        return Adresse;
    }

    public void setAdresse(Adresse adresse) {
        Adresse = adresse;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
