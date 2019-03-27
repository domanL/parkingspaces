package com.recruitment.project.parking.parkingspaces.repository;

import com.recruitment.project.parking.parkingspaces.domain.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository <Parking, Long> {
}
