package com.allianz.healthtourism.model.requestDTO.reservation;

import lombok.Data;

import java.util.UUID;

@Data
public class ReservationApproveRequestDTO {
    private UUID reservationUuid;
}
