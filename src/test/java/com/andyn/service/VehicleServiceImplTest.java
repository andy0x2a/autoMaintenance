package com.andyn.service;

import com.andyn.model.Maintenance;
import com.andyn.model.MaintenanceType;
import com.andyn.model.Vehicle;
import com.andyn.model.VehicleType;
import com.andyn.repository.MaintenanceRepository;
import com.andyn.repository.VehicleRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class VehicleServiceImplTest {

    private VehicleServiceImpl vehicleService = null;

    @Mock
    private VehicleRepository mockVehicleRepository;

    @Mock
    private MaintenanceRepository mockMaintenanceRepository;

    private static int VALID_MAINTENANCE_ID = 10;
    private static int INVALID_MAINTENANCE_ID = 2;
    private static int VALID_VEHICLE_ID = 8;


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        vehicleService = new VehicleServiceImpl(mockVehicleRepository, mockMaintenanceRepository);
    }

    @Test()
    public void testSave_ValidMaintenance() {

        List<Maintenance> maintenanceList = Arrays.asList(createMaintenance(VALID_MAINTENANCE_ID));
        VehicleType vehicleType = createVehicleMaintenance(VALID_VEHICLE_ID);

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setMaintenanceList(maintenanceList);
        vehicle.setVehicleType(vehicleType);

        vehicleService.saveVehicle(vehicle);

        verify(mockMaintenanceRepository, times(1)).save(maintenanceList);
        verify(mockVehicleRepository, times(1)).save(vehicle);
    }

    @Test(expected = IllegalStateException.class)
    public void testSave_InvalidId() {

        VehicleType vehicleType = createVehicleMaintenance(VALID_VEHICLE_ID);

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setVehicleType(vehicleType);

        vehicleService.saveVehicle(vehicle, 10);
    }

    @Test(expected = IllegalStateException.class)
    public void testSave_InvalidMaintenanceThrowsException() {

        Maintenance maintenance = createMaintenance(INVALID_MAINTENANCE_ID);
        VehicleType vehicleType = createVehicleMaintenance(VALID_VEHICLE_ID);


        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setMaintenanceList(Arrays.asList(maintenance));
        vehicle.setVehicleType(vehicleType);
        vehicleService.saveVehicle(vehicle);
    }

    private VehicleType createVehicleMaintenance(int vehicleTypeId) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setID(vehicleTypeId);


        if (vehicleTypeId == VALID_VEHICLE_ID) {
            vehicleType.setValidMaintenanceTypes(Arrays.asList(new MaintenanceType(VALID_MAINTENANCE_ID)));
        }
        return vehicleType;
    }

    private Maintenance createMaintenance(int typeId) {
        Maintenance invalidMaintenance = new Maintenance();
        MaintenanceType invalidMaintenanceType = new MaintenanceType(typeId);
        invalidMaintenance.setType(invalidMaintenanceType);
        return invalidMaintenance;
    }
}