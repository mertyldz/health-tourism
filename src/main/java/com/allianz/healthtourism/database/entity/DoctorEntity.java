package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
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
public class DoctorEntity extends BaseEntity {

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
    private String phoneNumber;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfessionEnum profession;

    // Add hospital info
    @ManyToOne
    @JoinTable(name = "hospital_id")
    private HospitalEntity hospital;
}
