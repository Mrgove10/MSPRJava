package com.recycl.dashboard.front.Models;

public class RequestTwoModel {
    private String Dechet;
    private int Quantite;

    public RequestTwoModel() {
    }

    public RequestTwoModel(String dechet, int quantite) {
        Dechet = dechet;
        Quantite = quantite;
    }

    public String getDechet() {
        return Dechet;
    }

    public void setDechet(String dechet) {
        Dechet = dechet;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }
}
