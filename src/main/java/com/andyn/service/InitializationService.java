package com.andyn.service;

import com.andyn.model.VehicleType;
import com.andyn.repository.MaintenanceRepository;
import com.andyn.repository.MaintenanceStatusRepository;
import com.andyn.repository.VehicleRepository;
import com.andyn.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Bootstraps the setup of the database, creating required data
 */
@Service
public class InitializationService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private MaintenanceStatusRepository maintenanceStatusRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    public void setupData() {
        deleteAllData();
        createVehicleTypes();
        createMaintenanceTypes();
        createMaintenance();
        createVehicles();

    }

    private void createVehicles() {

    }

    private void createMaintenance() {

    }

    private void createMaintenanceTypes() {

    }

    private void createVehicleTypes() {
        VehicleType gas = new VehicleType();
        gas.setType("Gas");

        VehicleType electric = new VehicleType();
        electric.setType("electric");

        VehicleType hybrid = new VehicleType();
        hybrid.setType("hybrid");

        vehicleTypeRepository.save(gas);
        vehicleTypeRepository.save(electric);
        vehicleTypeRepository.save(hybrid);


    }

    private void deleteAllData() {
        maintenanceRepository.deleteAll();
        vehicleRepository.deleteAll();
        vehicleTypeRepository.deleteAll();
        maintenanceStatusRepository.deleteAll();
    }
}
