package com.recycl.dashboard.back.Beans;

public class DetailDemande {
    private int Id;
    private DemandeEnlevement DemandeEnlevement;
    private int Quantite;

    public DetailDemande(int id, DemandeEnlevement demandeEnlevement, int quantite) {
        Id = id;
        DemandeEnlevement = demandeEnlevement;
        Quantite = quantite;
    }

    public DetailDemande() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public DemandeEnlevement getDemandeEnlevement() {
        return DemandeEnlevement;
    }

    public void setDemandeEnlevement(DemandeEnlevement demandeEnlevement) {
        DemandeEnlevement = demandeEnlevement;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }
}
