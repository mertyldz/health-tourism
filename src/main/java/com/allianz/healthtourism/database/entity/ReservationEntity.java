package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
public class ReservationEntity extends BaseEntity {

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate reservationDate;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfessionEnum treatmentProfession;

    // Reservation mapping.
    // CascadeType.ALL is not ok for this. Removing patient if reservation deleted is not desired.
    @OneToOne(mappedBy = "reservation",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private PatientEntity patient;

    // CascadeType.ALL is not ok for this. Removing doctor if reservation deleted is not desired.
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    // CascadeType.ALL is not ok for this. Removing hospital if reservation deleted is not desired.
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;


}