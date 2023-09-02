package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class HotelEntity extends BaseEntity {
    @Column
    private String hotelName;
    @Column
    private String city;
    @Column
    private String address;
    @Column
    private Integer takenCapacity;
    @Column
    private Integer totalCapacity;
    @Column
    private Integer price;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReservationEntity> reservationList;

}
