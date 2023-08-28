package com.allianz.healthtourism.model.requestDTO.examination;

import lombok.Data;

import java.util.UUID;

@Data
public class ExaminationAddPatientRequestDTO {
    private UUID examinationUuid;
    private UUID patientUuid;
}
