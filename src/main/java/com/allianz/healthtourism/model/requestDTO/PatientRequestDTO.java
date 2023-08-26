package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.model.enums.GenderEnum;
import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequestDTO extends BaseRequestDTO {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private GenderEnum gender;
    private String address;
    private String phoneNumber;
    private String email;
    private ReservationRequestDTO reservation;
    private ExaminationRequestDTO examination;

}
