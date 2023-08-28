package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.ExaminationEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.repository.ExaminationRepository;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.database.specification.PatientSpecification;
import com.allianz.healthtourism.exceptions.RecordNotFoundException;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.model.requestDTO.patient.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientService extends BaseService<
        PatientEntity,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientRepository,
        PatientSpecification> {

    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientSpecification patientSpecification;
    @Autowired
    ExaminationRepository examinationRepository;

    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return patientRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return patientSpecification;
    }

    public Boolean addPatientToExamination(UUID patientUuid, UUID examinationUuid) {
        ExaminationEntity examination = examinationRepository.findByUuid(examinationUuid).orElse(null);
        PatientEntity patient = patientRepository.findByUuid(patientUuid).orElse(null);
        if (examination == null) {
            throw new RecordNotFoundException("Examination not found!");
        }
        if (patient == null) {
            throw new RecordNotFoundException("Patient is not found!");
        }
        patient.setExamination(examination);
        patientRepository.save(patient);
        return Boolean.TRUE;

    }
}
