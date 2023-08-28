package com.allianz.healthtourism.model.requestDTO.flight;

import lombok.Data;

import java.util.UUID;

@Data
public class FlightAddPlaneRequestDTO {
    private UUID flightUuid;
    private UUID planeUuid;
}
