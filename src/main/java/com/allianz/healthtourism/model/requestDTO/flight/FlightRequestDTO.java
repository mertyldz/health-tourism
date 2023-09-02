package com.allianz.healthtourism.model.requestDTO.flight;

import com.allianz.healthtourism.utils.BaseRequestDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightRequestDTO extends BaseRequestDTO {
    private String flightNo;
    private String departureCity;
    private String arrivalCity;
    private Integer takenCapacity;
    private Integer totalCapacity;
    private Integer price;
    private LocalDateTime departureTime;
}
