package com.recycl.dashboard.back.Beans;

public class Centre {
    private int Id;
    private Adresse Adresse;
    private String Nom;

    public Centre(int id, Adresse adresse, String nom) {
        Id = id;
        Adresse = adresse;
        Nom = nom;
    }

    public Centre() {
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
