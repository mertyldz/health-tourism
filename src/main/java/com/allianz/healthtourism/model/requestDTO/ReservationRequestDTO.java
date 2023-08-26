package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequestDTO extends BaseRequestDTO {
    private LocalDate reservationDate;
    private ProfessionEnum treatmentProfession;
    private PatientRequestDTO patient;
    private DoctorRequestDTO doctor;
    private HospitalRequestDTO hospital;
    private HotelRequestDTO hotel;
    private FlightRequestDTO flight;
}
