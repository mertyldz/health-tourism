package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.utils.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO extends BaseDTO {
    private String hotelName;
    private String city;
    private String address;
    private Integer takenCapacity;
    private Integer totalCapacity;
    private Integer price;
}
