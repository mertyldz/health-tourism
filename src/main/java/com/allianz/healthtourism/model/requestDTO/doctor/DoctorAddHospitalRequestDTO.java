package com.allianz.healthtourism.model.requestDTO.doctor;

import lombok.Data;

import java.util.UUID;

@Data
public class DoctorAddHospitalRequestDTO {
    private UUID doctorUuid;
    private UUID hospitalUuid;
}
