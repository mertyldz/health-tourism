package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class ExaminationEntity extends BaseEntity {
    @Column
    private String diagnosis;

    @Column
    private String treatmentPrescription;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate examinationDate;

    @OneToOne(mappedBy = "examination")
    private PatientEntity patient;
}
