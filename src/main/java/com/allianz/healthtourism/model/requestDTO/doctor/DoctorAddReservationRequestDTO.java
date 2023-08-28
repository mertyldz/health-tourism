package com.allianz.healthtourism.model.requestDTO.doctor;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class DoctorAddReservationRequestDTO {
    private UUID doctorUuid;
    private List<UUID> reservationUuidList;
}
