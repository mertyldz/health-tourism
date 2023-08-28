package com.allianz.healthtourism.model.requestDTO.patient;

import lombok.Data;

import java.util.UUID;

@Data
public class PatientAddExaminationRequestDTO {
    private UUID patientUuid;
    private UUID examinationUuid;
}
