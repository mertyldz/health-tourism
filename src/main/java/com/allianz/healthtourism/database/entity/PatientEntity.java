package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.model.enums.GenderEnum;
import com.allianz.healthtourism.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class PatientEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @Column
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    // If patient deleted, also reservation should be deleted.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private ReservationEntity reservation;

    // If patient deleted, also examination should be deleted.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "examination_id")
    private ExaminationEntity examination;

}
