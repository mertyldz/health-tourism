package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.utils.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class FlightDTO extends BaseDTO {
    private String flightNo;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private Integer takenCapacity;
    private Integer totalCapacity;
    private Integer price;
    private PlaneDTO plane;

}
