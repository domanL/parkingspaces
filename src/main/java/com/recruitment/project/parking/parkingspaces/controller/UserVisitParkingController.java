package com.recruitment.project.parking.parkingspaces.controller;

import com.recruitment.project.parking.parkingspaces.domain.UserParkingVisit;
import com.recruitment.project.parking.parkingspaces.service.UserParkingVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/parking")
public class UserVisitParkingController {

    private UserParkingVisitService userParkingVisitService;

    @Autowired
    public UserVisitParkingController(UserParkingVisitService userParkingVisitService){
        this.userParkingVisitService=userParkingVisitService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getAllUserParkingVisit(){
        List<UserParkingVisit> allUserParkingVisit = userParkingVisitService.getAllUserParkingVisit();
        return ResponseEntity.ok().body(allUserParkingVisit);
    }

    @RequestMapping(value = "/start/{registration}",method = RequestMethod.GET)
    public ResponseEntity<?> startParkingVisit(@PathVariable("registration") String registrationNumber){
        userParkingVisitService.startUserParkingVisit(registrationNumber);
        return ResponseEntity.ok().body("OK");
    }


}
