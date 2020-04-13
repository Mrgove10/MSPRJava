package com.recycl.dashboard.back.Beans;

import java.util.Date;

public class Employe {
    private int Id;
    private Site Site;
    private String Nom;
    private String Prenom;
    private Date DateNaissance;
    private Date DateEmbauche;
    private float Salaire;
    private String Fonction;

    public Employe(int id, Site site, String nom, String prenom, Date dateNaissance, Date dateEmbauche, float salaire, String fonction) {
        Id = id;
        Site = site;
        Nom = nom;
        Prenom = prenom;
        DateNaissance = dateNaissance;
        DateEmbauche = dateEmbauche;
        Salaire = salaire;
        Fonction = fonction;
    }

    public Employe() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Site getSite() {
        return Site;
    }

    public void setSite(Site site) {
        Site = site;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Date getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        DateNaissance = dateNaissance;
    }

    public Date getDateEmbauche() {
        return DateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        DateEmbauche = dateEmbauche;
    }

    public float getSalaire() {
        return Salaire;
    }

    public void setSalaire(float salaire) {
        Salaire = salaire;
    }

    public String getFonction() {
        return Fonction;
    }

    public void setFonction(String fonction) {
        Fonction = fonction;
    }
}
