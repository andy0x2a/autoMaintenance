package com.andyn.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;

    @OneToOne( cascade = CascadeType.ALL)
    private MaintenanceStatus status;

    @OneToOne( cascade = CascadeType.ALL)
    private MaintenanceType type;

    public Maintenance() {
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public MaintenanceStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceStatus status) {
        this.status = status;
    }

    public MaintenanceType getType() {
        return type;
    }

    public void setType(MaintenanceType type) {
        this.type = type;
    }
}
