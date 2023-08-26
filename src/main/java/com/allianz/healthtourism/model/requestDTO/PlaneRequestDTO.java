package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlaneRequestDTO extends BaseRequestDTO {
    private String model;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private FlightRequestDTO flight;
}
