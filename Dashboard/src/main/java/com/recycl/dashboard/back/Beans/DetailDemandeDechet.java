package com.recycl.dashboard.back.Beans;

public class DetailDemandeDechet {
    private int Id;
    private DetailDemande DetailDemande;
    private Dechet Dechet;

    public DetailDemandeDechet(int id, DetailDemande detailDemande, Dechet dechet) {
        Id = id;
        DetailDemande = detailDemande;
        Dechet = dechet;
    }

    public DetailDemandeDechet() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public DetailDemande getDetailDemande() {
        return DetailDemande;
    }

    public void setDetailDemande(DetailDemande detailDemande) {
        DetailDemande = detailDemande;
    }

    public Dechet getDechet() {
        return Dechet;
    }

    public void setDechet(Dechet dechet) {
        Dechet = dechet;
    }
}
