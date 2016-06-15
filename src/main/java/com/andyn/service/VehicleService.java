package com.andyn.service;


import com.andyn.model.Vehicle;

public interface VehicleService {

    Iterable<Vehicle> findAllVehicles();

    Vehicle saveVehicle(Vehicle vehicle, int vehicleId);

    Vehicle getVehicleById(int id);

    Vehicle saveVehicle(Vehicle vehicle);

    void delete(int id);
}
