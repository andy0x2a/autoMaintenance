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
    private MaintenanceRepository maintenanceRepository;

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
        maintenanceRepository.save(vehicle.getMaintenanceList());
        return vehicleRepository.save(vehicle);

    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle, int vehicleId) {

        validateVehicleAndId(vehicle,vehicleId);
        validateVehicleAndMaintenance(vehicle);
        maintenanceRepository.save(vehicle.getMaintenanceList());
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


        for (Maintenance maintenance : vehicle.getMaintenanceList() ) {
            if(!vehicleTypeValidForMaintenanceType(maintenance.getType(),vehicle.getVehicleType())) {
                throw new IllegalStateException("Maintenance type not valid for vehicle type");
            }
        }
        return;
    }

    private boolean vehicleTypeValidForMaintenanceType(MaintenanceType vehicleMaintenanceType, VehicleType vehicleType) {

        if(vehicleMaintenanceType == null || vehicleType == null) {
            return false;
        }
        for(MaintenanceType maintenanceType : vehicleType.getValidMaintenanceTypes()) {
            if(maintenanceType.getID() == vehicleMaintenanceType.getID()) {
                return true;
            }
        }

        return false;
    }


}
