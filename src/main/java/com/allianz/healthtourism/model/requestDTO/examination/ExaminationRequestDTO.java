package com.allianz.healthtourism.model.requestDTO.examination;

import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExaminationRequestDTO extends BaseRequestDTO {
    private String diagnosis;
    private String treatmentPrescription;
    private LocalDateTime examinationDate;
}
