package com.recruitment.project.parking.parkingspaces.repository;

import com.recruitment.project.parking.parkingspaces.domain.ParkingOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingOwnerRepository extends JpaRepository<ParkingOwner, Long> {
}
