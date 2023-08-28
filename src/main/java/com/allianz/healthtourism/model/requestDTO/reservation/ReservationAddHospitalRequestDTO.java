package com.allianz.healthtourism.model.requestDTO.reservation;

import lombok.Data;

import java.util.UUID;

@Data
public class ReservationAddHospitalRequestDTO {
    private UUID reservationUuid;
    private UUID hospitalUuid;
}
