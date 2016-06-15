package com.andyn.model;

import javax.persistence.*;


@Entity
@Table(name = "maintenanceType")
public class MaintenanceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column()
    private String name;

    public MaintenanceType() {
    }

    public MaintenanceType(int id) {
        this.setID(id);
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

}
