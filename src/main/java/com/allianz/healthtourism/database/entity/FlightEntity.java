package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class FlightEntity extends BaseEntity {
    @Column
    private String flightNo;

    @Column
    private String departureCity;

    @Column
    private String arrivalCity;
    
    @Column
    private Integer takenCapacity;

    @Column
    private Integer totalCapacity;

    @Column
    private Integer price;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime departureTime;

    // Keep plane if flight is deleted
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "plane_id")
    private PlaneEntity plane;

    // add relation with reservation ....
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReservationEntity> reservationList;

}
