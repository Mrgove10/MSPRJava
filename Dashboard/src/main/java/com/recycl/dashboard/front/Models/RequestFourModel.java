package com.recycl.dashboard.front.Models;

public class RequestFourModel {
    private String Employe;
    private int NumberTournees;

    public RequestFourModel() {
    }

    public RequestFourModel(String employe, int numberTournees) {
        Employe = employe;
        NumberTournees = numberTournees;
    }

    public String getEmploye() {
        return Employe;
    }

    public void setEmploye(String employe) {
        Employe = employe;
    }

    public int getNumberTournees() {
        return NumberTournees;
    }

    public void setNumberTournees(int numberTournees) {
        NumberTournees = numberTournees;
    }
}
