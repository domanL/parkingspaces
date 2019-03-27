package com.recruitment.project.parking.parkingspaces.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "ParkingUser")
public class ParkingUser {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String mail;
    @OneToMany(mappedBy = "parkingUser")
    @JsonBackReference
    private List<UserVehicle> userVehicleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<UserVehicle> getUserVehicleList() {
        return userVehicleList;
    }

    public void setUserVehicleList(List<UserVehicle> userVehicleList) {
        this.userVehicleList = userVehicleList;
    }
}
