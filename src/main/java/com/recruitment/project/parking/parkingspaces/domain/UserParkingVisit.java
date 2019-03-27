package com.recruitment.project.parking.parkingspaces.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "UserParkingVisit")
public class UserParkingVisit {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate startParking;
    private LocalDate finishParking;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idUserVehicle")
    @JsonManagedReference
    private UserVehicle userVehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartParking() {
        return startParking;
    }

    public void setStartParking(LocalDate startParking) {
        this.startParking = startParking;
    }

    public LocalDate getFinishParking() {
        return finishParking;
    }

    public void setFinishParking(LocalDate finishParking) {
        this.finishParking = finishParking;
    }

    public UserVehicle getUserVehicle() {
        return userVehicle;
    }

    public void setUserVehicle(UserVehicle userVehicle) {
        this.userVehicle = userVehicle;
    }
}
