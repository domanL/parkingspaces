package com.recruitment.project.parking.parkingspaces.controller;

import com.recruitment.project.parking.parkingspaces.domain.UserParkingVisit;
import com.recruitment.project.parking.parkingspaces.service.UserParkingVisitService;
import org.springframework.beans.factory.annotation.Autowired;
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
        userParkingVisitService.startUserParkingVisit(registrationNumber, null, null);
        return ResponseEntity.ok().body("Started");
    }

    @RequestMapping(value = "/start/{registration}/{brand)/{model}",method = RequestMethod.GET)
    public ResponseEntity<?> startParkingVisit(@PathVariable("registration") String registrationNumber, @PathVariable("brand") String brand, @PathVariable("model") String model){
        userParkingVisitService.startUserParkingVisit(registrationNumber, brand, model);
        return ResponseEntity.ok().body("Started");
    }

    @RequestMapping(value = "/stop/{registration}",method = RequestMethod.GET)
    public ResponseEntity<?> endParkingVisit(@PathVariable("registration") String registrationNumber) {
        userParkingVisitService.endUserParkingVisit(registrationNumber);
        return ResponseEntity.ok().body("Finished");
    }

    @RequestMapping(value = "/is-starting/{registration}",method = RequestMethod.GET)
    public ResponseEntity<?> isStartingParkingVisit(@PathVariable("registration") String registrationNumber) {
        UserParkingVisit userParkingVisit = userParkingVisitService.isStartingUserParkingVisit(registrationNumber);
        return ResponseEntity.ok().body(userParkingVisit);
    }

    @RequestMapping(value = "/costVisit/{registration}/{isDisabled}",method = RequestMethod.GET)
    public ResponseEntity<?> getCostAllParkingVisit(@PathVariable("registration") String registrationNumber, @PathVariable("isDisabled") boolean isDisabled) {
        double costAllParkingVisit = userParkingVisitService.getCostAllParkingVisit(registrationNumber, isDisabled);
        return ResponseEntity.ok().body(costAllParkingVisit);
    }

}
