package com.andyn.controller;

import com.andyn.model.Vehicle;
import com.andyn.service.VehicleService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class VehicleControllerTest {

    VehicleController controller = null;

    @Mock
    VehicleService mockService;


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        controller = new VehicleController(mockService);

    }

    /**
     * Example Get Vehicles request
     * PARAM: GET
     * Endpoint: /vehicle/
     */
    @Test
    public void testListVehicles() {
        Iterable<Vehicle> mockResponse = new ArrayList<Vehicle>();
        when(mockService.findAllVehicles()).thenReturn(mockResponse);

        Iterable<Vehicle> response = controller.listVehicles();

        assertEquals(response, mockResponse);
    }

    /**
     * Example Get Vehicle by Id request
     * PARAM: GET
     * Endpoint: /vehicle/{id}
     */
    @Test
    public void testGetVehicleById() {

        Vehicle mockResponse = new Vehicle();
        int id = 4;
        when(mockService.getVehicleById(id)).thenReturn(mockResponse);
        Vehicle response = controller.getVehicleById(id);

        assertEquals(response, mockResponse);
    }


    /**
     * Example Creating vehicle
     * PARAM: POST
     * Endpoint: /vehicle/
     * Payload: vehicle Object
     */
    @Test
    public void testCreateVehicle() throws Exception {
        Vehicle requestVehicle = new Vehicle();

        when(mockService.saveVehicle(requestVehicle)).thenReturn(requestVehicle);
        Vehicle response = controller.createVehicle(requestVehicle);

        assertEquals(response, requestVehicle);
    }


    /**
     * Example Updating vehicle
     * PARAM: PUT
     * Endpoint: /vehicle/{id}
     * Payload: vehicle Object
     */
    @Test
    public void testUpdateVehicle() throws Exception {
        Vehicle requestVehicle = new Vehicle();
        int id = 4;
        when(mockService.saveVehicle(requestVehicle, id)).thenReturn(requestVehicle);
        Vehicle response = controller.updateVehicle(requestVehicle, 4);

        assertEquals(response, requestVehicle);
    }


    /**
     * Example Remove vehicle
     * PARAM: DELETE
     * Endpoint: /vehicle/{id}
     */
    @Test
    public void testRemoveVehicleById() throws Exception {
        int id = 4;
        controller.removeVehicleById(4);
        verify(mockService, times(1)).delete(id);

    }
}