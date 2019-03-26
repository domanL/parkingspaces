package com.recruitment.project.parking.parkingspaces.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "UserVehicle")
public class UserVehicle {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private String registration;
}
