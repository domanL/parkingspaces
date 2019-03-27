package com.recruitment.project.parking.parkingspaces.controller;

import com.recruitment.project.parking.parkingspaces.service.ParkingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/start-parking")
public class ParkingUserController {

    private ParkingUserService parkingUserService;

    @Autowired
    public ParkingUserController(ParkingUserService parkingUserService){
        this.parkingUserService = parkingUserService;
    }
}
