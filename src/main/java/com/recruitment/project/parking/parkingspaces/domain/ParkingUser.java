package com.recruitment.project.parking.parkingspaces.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ParkingUser")
public class ParkingUser {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String mail;


}
