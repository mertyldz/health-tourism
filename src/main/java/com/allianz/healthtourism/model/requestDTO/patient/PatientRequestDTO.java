package com.allianz.healthtourism.model.requestDTO.patient;

import com.allianz.healthtourism.model.enums.GenderEnum;
import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PatientRequestDTO extends BaseRequestDTO {
    private String name;
    private String surname;
    private LocalDateTime birthDate;
    private GenderEnum gender;
    private String address;
    private String phoneNumber;
    private String email;
}
