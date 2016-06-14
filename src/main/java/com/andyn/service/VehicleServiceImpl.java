package com.andyn.service;

import com.andyn.model.*;
import com.andyn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        validateVehicleAndMaintenance(vehicle);
        return vehicleRepository.save(vehicle);

    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle, int vehicleId) {

        validateVehicleAndId(vehicle,vehicleId);
        validateVehicleAndMaintenance(vehicle);
        return vehicleRepository.save(vehicle);

    }

    private void validateVehicleAndId(Vehicle vehicle, int vehicleId) {

        //TODO, add better validation
        if(vehicle.getId() != vehicleId) {
            throw new IllegalStateException("Vehicle Id incorrect");
        }
    }

    /**
     * Throws IllegalStateException if any of the maintenace are not applicable to the vehicle
     *
     * @param vehicle
     */
    private void validateVehicleAndMaintenance(Vehicle vehicle) throws IllegalStateException {
        //TODO, look into inverting this relationship.

        for (Maintenance maintenance : vehicle.getMaintenanceList()) {
            MaintenanceType vehicleMaintenanceType = maintenanceTypeRepository.findOne(maintenance.getType().getID());
            if (vehicleMaintenanceType != null) {
                if (!vehicleTypeValidForMaintenanceType(vehicleMaintenanceType,vehicle.getVehicleType())) {
                    throw new IllegalStateException("Vehicle not valid for maintenace Type");
                }
            } else {
                throw new IllegalStateException("Maintenance Type not found");
            }

        }
    }

    private boolean vehicleTypeValidForMaintenanceType(MaintenanceType vehicleMaintenanceType, VehicleType vehicleType) {

        if(vehicleMaintenanceType == null || vehicleType == null) {
            return false;
        }

        for(VehicleType validVehicle: vehicleMaintenanceType.getValidVehicles()) {
            if(validVehicle.getID() == vehicleType.getID()) {
                return true;
            }
        }

        return false;
    }


}
