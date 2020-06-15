package com.recycl.dashboard.back.Beans;

public class DetailDemandeDechet {
    private int Id;
    private DemandeEnlevement DetailDemande;
    private Dechet Dechet;
    private int Quantite;

    public DetailDemandeDechet() {
    }

    public DetailDemandeDechet(int id, DemandeEnlevement detailDemande, com.recycl.dashboard.back.Beans.Dechet dechet, int quantite) {
        Id = id;
        DetailDemande = detailDemande;
        Dechet = dechet;
        Quantite = quantite;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public DemandeEnlevement getDetailDemande() {
        return DetailDemande;
    }

    public void setDetailDemande(DemandeEnlevement detailDemande) {
        DetailDemande = detailDemande;
    }

    public com.recycl.dashboard.back.Beans.Dechet getDechet() {
        return Dechet;
    }

    public void setDechet(com.recycl.dashboard.back.Beans.Dechet dechet) {
        Dechet = dechet;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }
}
