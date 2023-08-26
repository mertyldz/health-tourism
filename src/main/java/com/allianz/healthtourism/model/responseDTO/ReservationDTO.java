package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseDTO;
import com.allianz.healthtourism.utils.BaseEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO extends BaseDTO {
    private LocalDate reservationDate;
    private ProfessionEnum treatmentProfession;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private HospitalDTO hospital;
    private HotelDTO hotel;
    private FlightDTO flight;
}
