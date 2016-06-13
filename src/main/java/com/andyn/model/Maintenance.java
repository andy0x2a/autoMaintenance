package com.andyn.model;

import javax.persistence.*;


@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue
    private int ID;

    @Column()
    private String name;

    @OneToOne()
    private MaintenanceStatus status;

    public Maintenance() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaintenanceStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceStatus status) {
        this.status = status;
    }
}
