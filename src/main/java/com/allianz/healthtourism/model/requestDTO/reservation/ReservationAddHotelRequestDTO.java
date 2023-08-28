package com.allianz.healthtourism.model.requestDTO.reservation;

import lombok.Data;

import java.util.UUID;

@Data
public class ReservationAddHotelRequestDTO {
    private UUID reservationUuid;
    private UUID hotelUuid;
}
