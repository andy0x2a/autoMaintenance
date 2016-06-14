package com.andyn.controller;

import com.andyn.model.Maintenance;
import com.andyn.model.MaintenanceStatus;
import com.andyn.model.MaintenanceType;
import com.andyn.repository.MaintenanceRepository;
import com.andyn.repository.MaintenanceStatusRepository;
import com.andyn.repository.MaintenanceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/maintenanceType")
@CrossOrigin()

public class MaintenanceTypeController {

    @Autowired
    private MaintenanceTypeRepository maintenanceTypeRepository;

    @Autowired
    private MaintenanceStatusRepository maintenanceStatusRepository;

    public MaintenanceTypeController() {

    }

    public MaintenanceTypeController(MaintenanceTypeRepository maintenanceTypeRepository) {
        this.maintenanceTypeRepository = maintenanceTypeRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<MaintenanceType> listMaintenanceTypeOptions() {
        return maintenanceTypeRepository.findAll();
    }

    @RequestMapping(value = "/statuses", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<MaintenanceStatus> listMaintenanceStatuses() {
        return maintenanceStatusRepository.findAll();
    }
}

