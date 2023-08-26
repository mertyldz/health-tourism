package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.enums.GenderEnum;
import com.allianz.healthtourism.utils.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO extends BaseDTO {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private GenderEnum gender;
    private String address;
    private String phoneNumber;
    private String email;
    private ReservationDTO reservation;
    private ExaminationDTO examination;

}
