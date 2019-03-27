package com.recruitment.project.parking.parkingspaces.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "Parking")
public class Parking {

    @Id
    @GeneratedValue
    private Long id;


}
