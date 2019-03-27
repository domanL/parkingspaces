package com.recruitment.project.parking.parkingspaces.repository;

import com.recruitment.project.parking.parkingspaces.domain.ParkingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingUserRepository extends JpaRepository<ParkingUser, Long> {
}
