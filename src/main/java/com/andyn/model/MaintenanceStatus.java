package com.andyn.model;


import javax.persistence.*;

@Entity
@Table(name = "maintenanceStatus")
public class MaintenanceStatus {


    @Id
    @GeneratedValue
    private int ID;

    public MaintenanceStatus() {
    }
    public MaintenanceStatus(String status) {
        this.status = status;
    }


    @Column()
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
