package com.allianz.healthtourism.model.requestDTO.reservation;

import lombok.Data;

import java.util.UUID;
@Data
public class ReservationAddDoctorRequestDTO {
    private UUID reservationUuid;
    private UUID doctorUuid;
}
