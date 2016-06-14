package com.andyn.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "maintenanceType")
public class MaintenanceType {

    @Id
    @GeneratedValue
    private int ID;

    @Column()
    private String name;

    @OneToMany
    private List<VehicleType> validVehicles;

    public MaintenanceType() {
    }

    public List<VehicleType> getValidVehicles() {
        return validVehicles;
    }

    public void setValidVehicles(List<VehicleType> validVehicles) {
        this.validVehicles = validVehicles;
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
