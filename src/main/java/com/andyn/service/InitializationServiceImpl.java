package com.andyn.service;

import com.andyn.model.*;
import com.andyn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Bootstraps the setup of the database, creating required data
 */
@Service
public class InitializationServiceImpl implements InitializationService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private MaintenanceStatusRepository maintenanceStatusRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private MaintenanceTypeRepository maintenanceTypeRepository;

    public void setupData() {

        Dictionary<String, MaintenanceType> maintenanceTypes = createMaintenanceTypes();
        Dictionary<String, VehicleType> vehicleTypes = createVehicleTypes(maintenanceTypes);
        Dictionary<String, MaintenanceStatus> maintenanceStatuses = createMaintenanceStatus();
        Iterable<Maintenance> sampleMaintenance = createMaintenanceList(maintenanceTypes, maintenanceStatuses);
        createVehicles(vehicleTypes, sampleMaintenance);

    }

    private void createVehicles(Dictionary<String, VehicleType> vehicleTypes, Iterable<Maintenance> sampleMaintenance) {
        Vehicle car = new Vehicle();
        car.setMake("Honda");
        car.setModel("Civic");
        car.setVehicleType(vehicleTypes.get("G"));

        ArrayList maintenanceList = new ArrayList();
        for (Maintenance maintenance : sampleMaintenance) {
            maintenanceList.add(maintenance);
        }

        car.setMaintenanceList(maintenanceList);

        vehicleRepository.save(car);
    }

    private Iterable<Maintenance> createMaintenanceList(Dictionary<String, MaintenanceType> maintenanceTypes,
                                                        Dictionary<String, MaintenanceStatus> maintenanceStatuses) {

        Maintenance oil = new Maintenance();
        oil.setType(maintenanceTypes.get("O"));
        oil.setStatus(maintenanceStatuses.get("P"));

        Maintenance oilExpired = new Maintenance();
        oilExpired.setType(maintenanceTypes.get("O"));
        oilExpired.setStatus(maintenanceStatuses.get("E"));

        return maintenanceRepository.save(Arrays.asList(oil, oilExpired));

    }

    private Dictionary<String, MaintenanceStatus> createMaintenanceStatus() {
        Dictionary<String, MaintenanceStatus> statuses = new Hashtable<String, MaintenanceStatus>();
        statuses.put("P", new MaintenanceStatus("Pending"));
        statuses.put("A", new MaintenanceStatus("Active"));
        statuses.put("F", new MaintenanceStatus("Finished"));
        statuses.put("E", new MaintenanceStatus("Expired"));
        statuses.put("D", new MaintenanceStatus("Deleted"));


        List<MaintenanceStatus> listOfStatuses = Arrays.asList(
                statuses.get("P"),
                statuses.get("A"),
                statuses.get("F"),
                statuses.get("E"),
                statuses.get("D")
        );

        maintenanceStatusRepository.save(listOfStatuses);


        return statuses;

    }

    private Dictionary<String, MaintenanceType> createMaintenanceTypes() {


        MaintenanceType oilChange = new MaintenanceType();
        oilChange.setName("Oil Change");
        oilChange = maintenanceTypeRepository.save(oilChange);

        MaintenanceType tireRotation = new MaintenanceType();
        tireRotation.setName("Tire Rotation");
        tireRotation = maintenanceTypeRepository.save(tireRotation);


        MaintenanceType batteryCharge = new MaintenanceType();
        batteryCharge.setName("Battery Charge");
        batteryCharge = maintenanceTypeRepository.save(batteryCharge);


        Dictionary<String, MaintenanceType> types = new Hashtable<String, MaintenanceType>();
        types.put("O", oilChange);
        types.put("T", tireRotation);
        types.put("B", batteryCharge);

        return types;
    }

    private Dictionary<String, VehicleType> createVehicleTypes(Dictionary<String, MaintenanceType> maintenanceTypes) {
        VehicleType gas = new VehicleType("Gas");
        gas.setValidMaintenanceTypes(Arrays.asList(maintenanceTypes.get("O"), maintenanceTypes.get("T")));

        VehicleType electric = new VehicleType("Electric");
        electric.setValidMaintenanceTypes(Arrays.asList(maintenanceTypes.get("B"), maintenanceTypes.get("T")));

        VehicleType hybrid = new VehicleType("Hybrid");
        hybrid.setValidMaintenanceTypes(Arrays.asList(maintenanceTypes.get("B"), maintenanceTypes.get("T"), maintenanceTypes.get("O")));

        gas = vehicleTypeRepository.save(gas);
        electric = vehicleTypeRepository.save(electric);
        hybrid = vehicleTypeRepository.save(hybrid);
        Dictionary<String, VehicleType> types = new Hashtable<String, VehicleType>();
        types.put("G", gas);
        types.put("E", electric);
        types.put("H", hybrid);

        return types;

    }

}
