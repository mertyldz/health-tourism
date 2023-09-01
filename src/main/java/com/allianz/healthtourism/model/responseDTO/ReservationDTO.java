package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDTO extends BaseDTO {
    private LocalDateTime reservationDate;
    private ProfessionEnum treatmentProfession;
    private Integer price;
    private Boolean approved;
    private Boolean paid;
    private DoctorDTO doctor;
    private HospitalDTO hospital;
    private HotelDTO hotel;
    private FlightDTO flight;
}
