package com.recruitment.project.parking.parkingspaces.service;

import com.recruitment.project.parking.parkingspaces.domain.UserParkingVisit;
import com.recruitment.project.parking.parkingspaces.repository.UserParkingVisitRepository;
import com.recruitment.project.parking.parkingspaces.repository.UserVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserParkingVisitServiceImpl implements UserParkingVisitService {

    @Autowired
    private UserParkingVisitRepository userParkingVisitRepository;

    @Autowired
    private UserVehicleRepository userVehicleRepository;

    @Override
    public List<UserParkingVisit> getAllUserParkingVisit(){
        return userParkingVisitRepository.findAll();
    }

    @Override
    public void startUserParkingVisit(String registrationNumber) {
        //userVehicleRepository.
    }


}
