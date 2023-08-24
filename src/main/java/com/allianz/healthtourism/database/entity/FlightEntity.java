package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.utils.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table
public class FlightEntity extends BaseEntity {
    @Column
    private String flightNo;
    @Column
    private String fromPlace;
    @Column
    private String toPlace;

    // Check is it ok
    @Column
    private LocalTime departureTime;

    // add relation with reservation ....
}
