package com.recycl.dashboard.front.Models;

public class RequestFiveModel {
    private int Id;
    private String NomEntreprise;
    private int NumberDemandes;

    public RequestFiveModel(int id, String nomEntreprise, int numberDemandes) {
        Id = id;
        NomEntreprise = nomEntreprise;
        NumberDemandes = numberDemandes;
    }

    public RequestFiveModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNomEntreprise() {
        return NomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        NomEntreprise = nomEntreprise;
    }

    public int getNumberDemandes() {
        return NumberDemandes;
    }

    public void setNumberDemandes(int numberDemandes) {
        NumberDemandes = numberDemandes;
    }
}
