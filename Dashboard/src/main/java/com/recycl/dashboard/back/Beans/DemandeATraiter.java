package com.recycl.dashboard.back.Beans;

public class DemandeATraiter {
    private int Id;
    private DemandeEnlevement Demande;

    public DemandeATraiter() {
    }

    public DemandeATraiter(int id, DemandeEnlevement demande) {
        Id = id;
        Demande = demande;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public DemandeEnlevement getDemande() {
        return Demande;
    }

    public void setDemande(DemandeEnlevement demande) {
        Demande = demande;
    }
}
