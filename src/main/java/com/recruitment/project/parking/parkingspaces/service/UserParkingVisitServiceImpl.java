package com.recruitment.project.parking.parkingspaces.service;

import com.recruitment.project.parking.parkingspaces.domain.UserParkingVisit;
import com.recruitment.project.parking.parkingspaces.domain.UserVehicle;
import com.recruitment.project.parking.parkingspaces.repository.UserParkingVisitRepository;
import com.recruitment.project.parking.parkingspaces.repository.UserVehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void startUserParkingVisit(String registrationNumber, String brand, String model) {
        UserVehicle userVehicle = userVehicleRepository.findByRegistration(registrationNumber);
        if(userVehicle == null) {
            userVehicle = new UserVehicle();
            userVehicle.setRegistration(registrationNumber);
            userVehicle.setBrand(brand);
            userVehicle.setModel(model);
            userVehicleRepository.save(userVehicle);
        }
        UserParkingVisit userParkingVisit = new UserParkingVisit();
        userParkingVisit.setUserVehicle(userVehicle);
        userParkingVisit.setStartParking(LocalDateTime.now());
        userParkingVisitRepository.save(userParkingVisit);
    }

    @Override
    public void endUserParkingVisit(String registrationNumber) {
        UserVehicle userVehicle = userVehicleRepository.findByRegistration(registrationNumber);
        if(userVehicle != null) {
            UserParkingVisit userParkingVisit = userParkingVisitRepository.findTopByUserVehicleOrderByStartParkingDesc(userVehicle);
            userParkingVisit.setFinishParking(LocalDateTime.now());
            userParkingVisitRepository.save(userParkingVisit);
            logger.info(userParkingVisit.getStartParking().toString());
        }
        else {
            logger.info("Vehicle with registration number: " + registrationNumber + "did not started park");
        }
    }

    @Override
    public UserParkingVisit isStartingUserParkingVisit(String registrationNumber) {
        UserVehicle userVehicle = userVehicleRepository.findByRegistration(registrationNumber);
        if(userVehicle != null) {
            UserParkingVisit userParkingVisit = userParkingVisitRepository.findTopByUserVehicleOrderByStartParkingDesc(userVehicle);
            return userParkingVisit;
        }
        else {
            logger.info("Vehicle with registration number: " + registrationNumber + " did not started park");
            return null;
        }


    }


}
