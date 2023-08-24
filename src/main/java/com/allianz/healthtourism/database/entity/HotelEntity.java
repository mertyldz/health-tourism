package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.utils.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    // add relations ....
}
