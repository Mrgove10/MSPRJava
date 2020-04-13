package com.recycl.dashboard.back.Beans;

public class Depot {
    private int Id;
    private Tournee Tournee;
    private Centre Centre;
    private int Quantite;

    public Depot(int id, Tournee tournee, Centre centre, int quantite) {
        Id = id;
        Tournee = tournee;
        Centre = centre;
        Quantite = quantite;
    }

    public Depot() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Tournee getTournee() {
        return Tournee;
    }

    public void setTournee(Tournee tournee) {
        Tournee = tournee;
    }

    public Centre getCentre() {
        return Centre;
    }

    public void setCentre(Centre centre) {
        Centre = centre;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }
}
