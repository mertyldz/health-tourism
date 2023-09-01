package com.allianz.healthtourism.model.requestDTO.reservation;

import lombok.Data;

import java.util.UUID;

@Data
public class ReservationPaymentRequestDTO {
    private UUID reservationUuid;
}
