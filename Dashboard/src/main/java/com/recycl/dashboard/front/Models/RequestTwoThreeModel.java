package com.recycl.dashboard.front.Models;

public class RequestTwoThreeModel {
    private String Dechet;
    private int Quantite;

    public RequestTwoThreeModel() {
    }

    public RequestTwoThreeModel(String dechet, int quantite) {
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
