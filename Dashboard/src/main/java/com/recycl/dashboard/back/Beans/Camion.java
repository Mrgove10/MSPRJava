package com.recycl.dashboard.back.Beans;

import java.util.Date;

public class Camion {
    private int Id;
    private Site Site;
    private String NumMatricule;
    private Date DateAchat;
    private String Modele;
    private String Marque;
    private int MaxPlaces;

    public Camion(int id, com.recycl.dashboard.back.Beans.Site site, String numMatricule, Date dateAchat, String modele, String marque, int maxPlaces) {
        Id = id;
        Site = site;
        NumMatricule = numMatricule;
        DateAchat = dateAchat;
        Modele = modele;
        Marque = marque;
        MaxPlaces = maxPlaces;
    }

    public Camion() {
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

    public String getNumMatricule() {
        return NumMatricule;
    }

    public void setNumMatricule(String numMatricule) {
        NumMatricule = numMatricule;
    }

    public Date getDateAchat() {
        return DateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        DateAchat = dateAchat;
    }

    public String getModele() {
        return Modele;
    }

    public void setModele(String modele) {
        Modele = modele;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public int getMaxPlaces() {
        return MaxPlaces;
    }

    public void setMaxPlaces(int maxPlaces) {
        MaxPlaces = maxPlaces;
    }
}
