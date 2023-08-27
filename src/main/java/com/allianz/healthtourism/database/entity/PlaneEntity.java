package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity
public class PlaneEntity extends BaseEntity {
    @Column
    private String model;

    @Column
    private String airline;

    @OneToOne(mappedBy = "plane", cascade = CascadeType.ALL)
    private FlightEntity flight;
}
