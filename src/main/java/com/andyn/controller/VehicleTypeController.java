package com.andyn.controller;

import com.andyn.model.VehicleType;
import com.andyn.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vehicleType")
@CrossOrigin()

public class VehicleTypeController {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeController() {

    }

    public VehicleTypeController(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<VehicleType> listMaintenanceTypeOptions() {
        return vehicleTypeRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeTypeById(@PathVariable int id) {
        vehicleTypeRepository.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Iterable<VehicleType> saveVehicleTypes(@RequestBody List<VehicleType> vehicles) {
        return vehicleTypeRepository.save(vehicles);

    }
}
