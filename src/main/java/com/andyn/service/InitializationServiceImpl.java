package com.andyn.service;

import com.andyn.model.*;
import com.andyn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Bootstraps the setup of the database, creating required data
 */
@Service
public class InitializationServiceImpl  implements InitializationService{

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
//        deleteAllData();
        Dictionary<String, VehicleType> vehicleTypes = createVehicleTypes();
        Dictionary<String, MaintenanceType> maintenanceTypes = createMaintenanceStatusesAndTypes(vehicleTypes);
        createMaintenance(maintenanceTypes);
        createMaintenanceStatus();
        createVehicles(vehicleTypes);

    }

    private void createVehicles(Dictionary<String, VehicleType> vehicleTypes) {
        Vehicle  car = new Vehicle();
        car.setMake("Honda");
        car.setModel("Civic");
        car.setVehicleType(vehicleTypes.get("E"));
        vehicleRepository.save(car);
    }

    private void createMaintenance(Dictionary<String, MaintenanceType> maintenanceTypes) {

        Maintenance maintenance = new Maintenance();
        maintenance.setType(maintenanceTypes.get("O"));
        maintenanceRepository.save(maintenance);

    }

    private Dictionary<String,MaintenanceStatus> createMaintenanceStatus(){
        Dictionary<String, MaintenanceStatus> statuses = new Hashtable<String, MaintenanceStatus>();
        statuses.put("P",new MaintenanceStatus("Pending"));
        statuses.put("A",new MaintenanceStatus("Active"));
        statuses.put("F",new MaintenanceStatus("Finished"));
        statuses.put("E",new MaintenanceStatus("Expired"));
        statuses.put("D",new MaintenanceStatus("Deleted"));


        List<MaintenanceStatus> listOfStatuses = Arrays.asList(
                statuses.get("P"),
                statuses.get("A"),
                statuses.get("F"),
                statuses.get("E"),
                statuses.get("D")
        );

        Iterable<MaintenanceStatus> savedStatusList = maintenanceStatusRepository.save(listOfStatuses);


        return statuses;

    }

    private Dictionary<String, MaintenanceType> createMaintenanceStatusesAndTypes(Dictionary<String, VehicleType> vehicleTypes) {


        MaintenanceType oilChange = new MaintenanceType();
        oilChange.setName("OilChange");
        List<VehicleType> validOilChangeTypes = Arrays.asList(vehicleTypes.get("G"),vehicleTypes.get("H"));
        oilChange.setValidVehicles(validOilChangeTypes);
        oilChange = maintenanceTypeRepository.save(oilChange);

        MaintenanceType tireRotation = new MaintenanceType();
        tireRotation.setName("Tire Rotation");
        List<VehicleType> validTireRotationTypes = Arrays.asList(vehicleTypes.get("G"),vehicleTypes.get("H"), vehicleTypes.get("E"));
        tireRotation.setValidVehicles(validTireRotationTypes);
        tireRotation = maintenanceTypeRepository.save(tireRotation);


        MaintenanceType batteryCharge = new MaintenanceType();
        batteryCharge.setName("Battery Charge");
        List<VehicleType> validBatteryChargeTypes = Arrays.asList(vehicleTypes.get("H"), vehicleTypes.get("E"));
        batteryCharge.setValidVehicles(validBatteryChargeTypes);
        batteryCharge = maintenanceTypeRepository.save(batteryCharge);


        Dictionary<String, MaintenanceType> types = new Hashtable<String, MaintenanceType>();
        types.put("O",oilChange);
        types.put("T",tireRotation);
        types.put("B",batteryCharge);

        return types;
    }

    private Dictionary<String, VehicleType> createVehicleTypes() {
        VehicleType gas = new VehicleType("Gas");
        VehicleType electric = new VehicleType("Electric");
        VehicleType hybrid = new VehicleType("Hybrid");

        gas = vehicleTypeRepository.save(gas);
        electric = vehicleTypeRepository.save(electric);
        hybrid = vehicleTypeRepository.save(hybrid);
        Dictionary<String, VehicleType> types = new Hashtable<String, VehicleType>();
        types.put("G",gas);
        types.put("E",electric);
        types.put("H",hybrid);

        return types;

    }

    private void deleteAllData() {
        maintenanceRepository.deleteAll();
        vehicleRepository.deleteAll();
        vehicleTypeRepository.deleteAll();
        maintenanceStatusRepository.deleteAll();
    }
}
