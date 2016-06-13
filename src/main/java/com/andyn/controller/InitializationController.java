package com.andyn.controller;


import com.andyn.service.InitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/init")
@CrossOrigin()
public class InitializationController {


  @Autowired
  private InitializationService initializationService;

    public InitializationController() {

    }

    public  InitializationController(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void setup() {
        System.out.println("initializing!");
        initializationService.setupData();

    }


}
