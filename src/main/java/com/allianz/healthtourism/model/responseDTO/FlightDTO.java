package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.utils.BaseDTO;
import lombok.Data;

import java.util.List;
@Data
public class FlightDTO extends BaseDTO {
    private String flightNo;
    private PlaneDTO plane;
    private List<ReservationDTO> reservationList;

}
