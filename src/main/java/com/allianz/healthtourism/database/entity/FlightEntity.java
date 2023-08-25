package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

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
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReservationEntity> reservationList;

}
