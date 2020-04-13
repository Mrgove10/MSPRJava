package com.recycl.dashboard.back.Beans;

public class DechetDepot {
    private int Id;
    private Dechet Dechet;
    private Depot Depot;

    public DechetDepot(int id, Dechet dechet, Depot depot) {
        Id = id;
        Dechet = dechet;
        Depot = depot;
    }

    public DechetDepot() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Dechet getDechet() {
        return Dechet;
    }

    public void setDechet(Dechet dechet) {
        Dechet = dechet;
    }

    public Depot getDepot() {
        return Depot;
    }

    public void setDepot(Depot depot) {
        Depot = depot;
    }
}
