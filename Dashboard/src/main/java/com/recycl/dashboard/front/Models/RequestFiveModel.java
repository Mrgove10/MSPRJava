package com.recycl.dashboard.front.Models;

public class RequestFiveModel {
    private final int Id;
    private String NomEntreprise;

    public RequestFiveModel(String nomEntreprise, int id) {
        Id = id;
        NomEntreprise = nomEntreprise;
    }

    public int getId() {
        return Id;
    }

    public String getNomEntreprise() {
        return NomEntreprise;
    }

    @Override
    public String toString() {
        return getNomEntreprise();
    }
}
