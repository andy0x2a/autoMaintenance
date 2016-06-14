package com.andyn.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "maintenanceType")
public class MaintenanceType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;

    @Column()
    private String name;


    @ManyToMany
    @JoinTable(
            name="maintenance_allowed_types",
            joinColumns=@JoinColumn(name="mtype_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="vtype_id", referencedColumnName="id"))
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
