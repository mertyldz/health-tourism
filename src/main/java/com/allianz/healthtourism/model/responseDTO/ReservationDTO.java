package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDTO extends BaseDTO {
    private LocalDateTime reservationDate;
    private ProfessionEnum treatmentProfession;
    private DoctorDTO doctor;
    private HospitalDTO hospital;
    private HotelDTO hotel;
    private FlightDTO flight;
}
