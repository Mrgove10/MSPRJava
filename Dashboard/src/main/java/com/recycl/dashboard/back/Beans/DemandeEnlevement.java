package com.recycl.dashboard.back.Beans;

import java.util.Date;

public class DemandeEnlevement {
    private int Id;
    private Entreprise Entreprise;
    private Tournee Tournee;
    private int Numero;
    private Date DateDemande;
    private Date DateEnlevement;

    public DemandeEnlevement(int id, Entreprise entreprise, Tournee tournee, int numero, Date dateDemande, Date dateEnlevement) {
        Id = id;
        Entreprise = entreprise;
        Tournee = tournee;
        Numero = numero;
        DateDemande = dateDemande;
        DateEnlevement = dateEnlevement;
    }

    public DemandeEnlevement() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Entreprise getEntreprise() {
        return Entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        Entreprise = entreprise;
    }

    public Tournee getTournee() {
        return Tournee;
    }

    public void setTournee(Tournee tournee) {
        Tournee = tournee;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
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
