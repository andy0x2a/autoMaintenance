package com.andyn.model;


import javax.persistence.*;

@Entity
@Table(name = "vehicleType")
public class VehicleType {


    @Id
    @GeneratedValue
    private int ID;

    @Column()
    private String type;

    public VehicleType() {
    }
    public VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

