package com.recycl.dashboard.back.Beans;

public class Adresse {
    private int Id;
    private int NumRue;
    private String Rue;
    private int CodePostal;
    private String Ville;

    public Adresse(int id, int numRue, String rue, int codePostal, String ville) {
        Id = id;
        NumRue = numRue;
        Rue = rue;
        CodePostal = codePostal;
        Ville = ville;
    }

    public Adresse() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNumRue() {
        return NumRue;
    }

    public void setNumRue(int numRue) {
        NumRue = numRue;
    }

    public String getRue() {
        return Rue;
    }

    public void setRue(String rue) {
        Rue = rue;
    }

    public int getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(int codePostal) {
        CodePostal = codePostal;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }
}
