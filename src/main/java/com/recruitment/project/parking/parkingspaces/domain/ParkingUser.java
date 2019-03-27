package com.recruitment.project.parking.parkingspaces.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(mappedBy = "parkingUser")
    @JsonBackReference
    private List<UserVehicle> userVehicleList;

}
