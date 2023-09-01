package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class HospitalEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String city;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private List<ProfessionEnum> professionList;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DoctorEntity> doctorList;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ReservationEntity> reservationList;

    @Override
    public String toString() {
        return "HospitalEntity{" +
                "name='" + name + '\'' +
                ", address='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", professionList=" + professionList +
                ", doctorList=" + doctorList +
                ", reservationList=" + reservationList +
                '}';
    }
}
