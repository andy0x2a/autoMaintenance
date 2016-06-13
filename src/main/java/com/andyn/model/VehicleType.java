package com.andyn.model;


import javax.persistence.*;

@Entity
@Table(name = "vehicleType")
public class VehicleType {


    @Id
    @GeneratedValue
    private int ID;

    @Column()
    private String Type;

    public VehicleType() {
    }


    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

