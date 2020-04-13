package com.recycl.dashboard.back.Beans;

public class Dechet {
    private int Id;
    private String Type;
    private String Unite;
    private float LimiteForfait;
    private float TarifForfait;
    private float TarifLot;
    private int NbLot;
    private Danger Danger;

    public Dechet(int id, String type, String unite, float limiteForfait, float tarifForfait, float tarifLot, int nbLot, Danger danger) {
        Id = id;
        Type = type;
        Unite = unite;
        LimiteForfait = limiteForfait;
        TarifForfait = tarifForfait;
        TarifLot = tarifLot;
        NbLot = nbLot;
        Danger = danger;
    }

    public Dechet() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUnite() {
        return Unite;
    }

    public void setUnite(String unite) {
        Unite = unite;
    }

    public float getLimiteForfait() {
        return LimiteForfait;
    }

    public void setLimiteForfait(float limiteForfait) {
        LimiteForfait = limiteForfait;
    }

    public float getTarifForfait() {
        return TarifForfait;
    }

    public void setTarifForfait(float tarifForfait) {
        TarifForfait = tarifForfait;
    }

    public float getTarifLot() {
        return TarifLot;
    }

    public void setTarifLot(float tarifLot) {
        TarifLot = tarifLot;
    }

    public int getNbLot() {
        return NbLot;
    }

    public void setNbLot(int nbLot) {
        NbLot = nbLot;
    }

    public Danger getDanger() {
        return Danger;
    }

    public void setDanger(Danger danger) {
        Danger = danger;
    }
}
