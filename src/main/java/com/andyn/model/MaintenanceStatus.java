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

    @Column()
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
