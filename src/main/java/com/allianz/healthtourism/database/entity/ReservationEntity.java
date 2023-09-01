package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Table
@Entity
public class ReservationEntity extends BaseEntity {
    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime reservationDate;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfessionEnum treatmentProfession;

    @Column
    private Integer price;

    @Column
    private Boolean approved;

    @Column
    private Boolean paid;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;

}
