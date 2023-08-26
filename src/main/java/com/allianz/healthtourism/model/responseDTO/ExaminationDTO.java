package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.utils.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExaminationDTO extends BaseDTO {
    private String diagnosis;
    private String treatmentPrescription;
    private LocalDate examinationDate;
    private PatientDTO patient;
}
