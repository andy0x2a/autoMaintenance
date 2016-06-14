package com.andyn.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicleType")
public class VehicleType {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;

    @Column()
    private String type;

//
//    @Column
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "validVehicles")
//    List<MaintenanceType> validMaintenanceTypes;



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

//    public List<MaintenanceType> getValidMaintenanceTypes() {
//        return validMaintenanceTypes;
//    }
//
//    public void setValidMaintenanceTypes(List<MaintenanceType> validMaintenanceTypes) {
//        this.validMaintenanceTypes = validMaintenanceTypes;
//    }
}

