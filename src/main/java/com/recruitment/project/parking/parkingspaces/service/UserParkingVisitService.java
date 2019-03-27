package com.recruitment.project.parking.parkingspaces.service;

import com.recruitment.project.parking.parkingspaces.domain.UserParkingVisit;

import java.util.List;

public interface UserParkingVisitService {

    public List<UserParkingVisit> getAllUserParkingVisit();
    void startUserParkingVisit(String registrationNumber);
}
