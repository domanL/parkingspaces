package com.recruitment.project.parking.parkingspaces.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "UserVehicle")
public class UserVehicle {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private String registration;
    @OneToMany(mappedBy = "userVehicle")
    @JsonBackReference
    private List<UserParkingVisit> userParkingVisitList;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idParkingUser")
    @JsonManagedReference
    private ParkingUser parkingUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public List<UserParkingVisit> getUserParkingVisitList() {
        return userParkingVisitList;
    }

    public void setUserParkingVisitList(List<UserParkingVisit> userParkingVisitList) {
        this.userParkingVisitList = userParkingVisitList;
    }

    public ParkingUser getParkingUser() {
        return parkingUser;
    }

    public void setParkingUser(ParkingUser parkingUser) {
        this.parkingUser = parkingUser;
    }
}

