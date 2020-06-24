package com.recycl.dashboard.front.Models;

public class RequestFiveModel {
    private final int Id;
    private String NomEntreprise;
    private int NumberDemandes;

    public RequestFiveModel(String nomEntreprise, int id) {
        Id = id;
        NomEntreprise = nomEntreprise;
    }

    public RequestFiveModel(String nomEntreprise, int id, int numberDemandes) {
        Id = id;
        NomEntreprise = nomEntreprise;
        NumberDemandes = numberDemandes;
    }

    public int getId() {
        return Id;
    }

    public String getNomEntreprise() {
        return NomEntreprise;
    }

    public int getNumberDemandes(){
        return NumberDemandes;
    }

    @Override
    public String toString() {
        return getNomEntreprise();
    }

}
