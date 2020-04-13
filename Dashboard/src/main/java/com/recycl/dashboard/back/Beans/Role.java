package com.recycl.dashboard.back.Beans;

public class Role {
    private int id = 0;
    private String type = "";

    public Role(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
