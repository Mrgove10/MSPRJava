package com.recycl.dashboard.back.Beans;

import java.util.Date;

public class Tournee {
    private int Id;
    private Employe Employe;
    private Camion Camion;
    private Date Date;

    public Tournee(int id, Employe employe, Camion camion, Date date) {
        Id = id;
        Employe = employe;
        Camion = camion;
        Date = date;
    }

    public Tournee() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Employe getEmploye() {
        return Employe;
    }

    public void setEmploye(Employe employe) {
        Employe = employe;
    }

    public Camion getCamion() {
        return Camion;
    }

    public void setCamion(Camion camion) {
        Camion = camion;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }
}
