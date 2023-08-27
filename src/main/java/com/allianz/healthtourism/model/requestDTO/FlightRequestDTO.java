package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightRequestDTO extends BaseRequestDTO {
    private String flightNo;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
}
