package com.andyn.controller;

import com.andyn.model.MaintenanceType;
import com.andyn.model.VehicleType;
import com.andyn.repository.MaintenanceTypeRepository;
import com.andyn.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
        System.out.println("Listing!");
        return vehicleTypeRepository.findAll();
    }
}
