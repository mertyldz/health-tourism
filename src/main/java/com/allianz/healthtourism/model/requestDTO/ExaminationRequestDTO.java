package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExaminationRequestDTO extends BaseRequestDTO {
    private String diagnosis;
    private String treatmentPrescription;
    private LocalDate examinationDate;
    private PatientRequestDTO patient;
}
