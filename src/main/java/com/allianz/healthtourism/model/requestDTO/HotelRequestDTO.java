package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequestDTO extends BaseRequestDTO {
    private String hotelName;
    private String city;
    private String address;
    private Integer takenCapacity;
    private Integer totalCapacity;
    private List<ReservationRequestDTO> reservationList;
}
