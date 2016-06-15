package com.andyn.controller;

import com.andyn.model.Maintenance;
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

    public MaintenanceController(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Maintenance> listMaintenanceOptions() {
        return maintenanceRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Maintenance getMaintenanceById(@PathVariable int id) {
        return maintenanceRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeMaintenanceById(@PathVariable int id) {
        maintenanceRepository.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }


}
