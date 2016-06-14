package com.andyn.service;

import com.andyn.model.*;
import com.andyn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private MaintenanceTypeRepository maintenanceTypeRepository;


    @Override
    public boolean isVehicleValidForMaintenance(Vehicle vehicle, MaintenanceType maintenanceType) {
        return maintenanceType.getValidVehicles().contains(vehicle.getVehicleType());
    }

    @Override
    public Iterable<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return vehicleRepository.findOne(id);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {

        validateVehicleAndMaintenanve(vehicle);
        return vehicleRepository.save(vehicle);

    }

    /**
     * Throws InvalidStateException if any of the maintenace are not applicable to the vehicle
     *
     * @param vehicle
     */
    private void validateVehicleAndMaintenanve(Vehicle vehicle) throws IllegalStateException {
        //TODO, look into inverting this relationship.

        for (Maintenance maintenance : vehicle.getMaintenanceList()) {
            MaintenanceType vehicleMaintenanceType = maintenanceTypeRepository.findOne(maintenance.getType().getID());
            if (vehicleMaintenanceType != null) {
                if (!vehicleMaintenanceType.getValidVehicles().contains(vehicle.getVehicleType())) {
                    throw new IllegalStateException("Vehicle not valid for maintenace Type");
                }
            } else {
                throw new IllegalStateException("Maintenance Type not found");
            }

        }
    }


}
