package com.andyn.service;


import com.andyn.model.Maintenance;
import com.andyn.model.MaintenanceType;
import com.andyn.model.Vehicle;

public interface VehicleService {

    boolean isVehicleValidForMaintenance(Vehicle vehicle, MaintenanceType maintenance);

    Iterable<Vehicle> findAllVehicles();

    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle getVehicleById(int id);
}