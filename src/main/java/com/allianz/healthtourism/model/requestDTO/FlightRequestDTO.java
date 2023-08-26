package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class FlightRequestDTO extends BaseRequestDTO {
    private String flightNo;
    private PlaneRequestDTO plane;
    private List<ReservationRequestDTO> reservationList;
}
