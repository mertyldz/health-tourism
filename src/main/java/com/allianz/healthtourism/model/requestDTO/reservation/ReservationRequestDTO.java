package com.allianz.healthtourism.model.requestDTO.reservation;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.model.requestDTO.doctor.DoctorRequestDTO;
import com.allianz.healthtourism.model.requestDTO.flight.FlightRequestDTO;
import com.allianz.healthtourism.model.requestDTO.hospital.HospitalRequestDTO;
import com.allianz.healthtourism.model.requestDTO.hotel.HotelRequestDTO;
import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationRequestDTO extends BaseRequestDTO {
    private LocalDateTime reservationDate;
    private ProfessionEnum treatmentProfession;
    private DoctorRequestDTO doctor;
    private HospitalRequestDTO hospital;
    private HotelRequestDTO hotel;
    private FlightRequestDTO flight;
}
