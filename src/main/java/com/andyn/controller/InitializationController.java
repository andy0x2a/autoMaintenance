package com.andyn.controller;


import com.andyn.service.InitializationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
@CrossOrigin()
public class InitializationController {


    @Autowired
    private InitializationServiceImpl initializationService;

    public InitializationController() {

    }

    public InitializationController(InitializationServiceImpl initializationService) {
        this.initializationService = initializationService;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void setup() {
        initializationService.setupData();

    }


}
