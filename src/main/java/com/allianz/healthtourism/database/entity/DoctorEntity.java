package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.model.enums.GenderEnum;
import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class DoctorEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDate birthDate;

    @Column
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private Integer takenCapacity;

    @Column
    private Integer totalCapacity;

    @Column
    private Integer price;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfessionEnum profession;

    // Add hospital info
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReservationEntity> reservationList;

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", profession=" + profession +
//                ", hospital=" + hospital +
                ", reservationList=" + reservationList +
                '}';
    }
}
