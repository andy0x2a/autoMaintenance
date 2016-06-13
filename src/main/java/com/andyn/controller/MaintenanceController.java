package com.andyn.controller;

import  com.andyn.model.Maintenance;
import com.andyn.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/maintenance")
@CrossOrigin()

public class MaintenanceController {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public MaintenanceController() {

    }

    public  MaintenanceController(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Maintenance> listMaintenanceOptions() {
        System.out.println("Listing!");
        return maintenanceRepository.findAll();
    }
}
