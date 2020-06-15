package com.recycl.dashboard.back.Beans;

public class Entreprise {
    private int Id;
    private Adresse Adresse;
    private long Siret;
    private String RaisonSociale;
    private String Tel;
    private String NomContact;

    public Entreprise(int id, Adresse adresse, long siret, String raisonSociale, String tel, String nomContact) {
        Id = id;
        Adresse = adresse;
        Siret = siret;
        RaisonSociale = raisonSociale;
        Tel = tel;
        NomContact = nomContact;
    }

    public Entreprise() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Adresse getAdresse() {
        return Adresse;
    }

    public void setAdresse(Adresse adresse) {
        Adresse = adresse;
    }

    public long getSiret() {
        return Siret;
    }

    public void setSiret(long siret) {
        Siret = siret;
    }

    public String getRaisonSociale() {
        return RaisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        RaisonSociale = raisonSociale;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getNomContact() {
        return NomContact;
    }

    public void setNomContact(String nomContact) {
        NomContact = nomContact;
    }
}
