package com.recycl.dashboard.front.Models;


import java.sql.Date;

public class DemandeEnlevementModel {
    private int Id;
    private String Entreprise;
    private Date Tournee;
    private Date DateDemande;
    private Date DateEnlevement;

    public DemandeEnlevementModel() {
    }

    public DemandeEnlevementModel(int id, String entreprise, Date tournee, Date dateDemande, Date dateEnlevement) {
        Id = id;
        Entreprise = entreprise;
        Tournee = tournee;
        DateDemande = dateDemande;
        DateEnlevement = dateEnlevement;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEntreprise() {
        return Entreprise;
    }

    public void setEntreprise(String entreprise) {
        Entreprise = entreprise;
    }

    public Date getTournee() {
        return Tournee;
    }

    public void setTournee(Date tournee) {
        Tournee = tournee;
    }

    public Date getDateDemande() {
        return DateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        DateDemande = dateDemande;
    }

    public Date getDateEnlevement() {
        return DateEnlevement;
    }

    public void setDateEnlevement(Date dateEnlevement) {
        DateEnlevement = dateEnlevement;
    }
}
