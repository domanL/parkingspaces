package com.recruitment.project.parking.parkingspaces.repository;

import com.recruitment.project.parking.parkingspaces.domain.UserParkingVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserParkingVisitRepository extends JpaRepository<UserParkingVisit, Long> {
}
