package com.andyn.controller;

import com.andyn.model.Vehicle;
import com.andyn.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vehicle")
@CrossOrigin()

public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    public VehicleController() {

    }

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Vehicle> listVehicles() {
        return vehicleService.findAllVehicles();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Vehicle getVehicleById(@PathVariable int id) {
        return vehicleService.getVehicleById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);

    }

    @RequestMapping(value = "/{vehicleId}", method = RequestMethod.PUT)
    @ResponseBody
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable(value = "vehicleId") int vehicleId) {
        return vehicleService.saveVehicle(vehicle, vehicleId);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeVehicleById(@PathVariable int id) {
        vehicleService.delete(id);
    }
}
