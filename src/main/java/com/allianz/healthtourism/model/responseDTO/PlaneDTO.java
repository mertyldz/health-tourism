package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.utils.BaseDTO;
import com.allianz.healthtourism.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class PlaneDTO extends BaseDTO {
    private String model;
    private String airline;
}
