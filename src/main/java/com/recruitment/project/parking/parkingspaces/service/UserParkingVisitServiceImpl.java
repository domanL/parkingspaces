package com.recruitment.project.parking.parkingspaces.service;

import com.recruitment.project.parking.parkingspaces.domain.UserParkingVisit;
import com.recruitment.project.parking.parkingspaces.domain.UserVehicle;
import com.recruitment.project.parking.parkingspaces.repository.UserParkingVisitRepository;
import com.recruitment.project.parking.parkingspaces.repository.UserVehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserParkingVisitServiceImpl implements UserParkingVisitService {

    private static final Logger logger = LoggerFactory.getLogger(UserParkingVisitServiceImpl.class);

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
        UserVehicle userVehicle = userVehicleRepository.findByRegistration(registrationNumber);
        if(userVehicle == null) {
            userVehicle = new UserVehicle();
            userVehicle.setRegistration(registrationNumber);
            userVehicle.setBrand("Mercedes");
            userVehicle.setModel("Benz");
            userVehicleRepository.save(userVehicle);
        }
        UserParkingVisit userParkingVisit = new UserParkingVisit();
        userParkingVisit.setUserVehicle(userVehicle);
        userParkingVisit.setStartParking(LocalDateTime.now());
        userParkingVisitRepository.save(userParkingVisit);
    }


}
