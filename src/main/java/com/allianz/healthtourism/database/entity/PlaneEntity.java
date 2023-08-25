package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Table
@Entity
public class PlaneEntity extends BaseEntity {
    @Column
    private String model;

    @Column
    private String airline;

    @Column
    private String departureCity;

    @Column
    private String arrivalCity;

    @Column
    private LocalTime departureTime;

    @OneToOne(mappedBy = "plane", cascade = CascadeType.ALL)
    private FlightEntity flight;
}
