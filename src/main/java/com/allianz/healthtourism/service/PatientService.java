package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.database.specification.PatientSpecification;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
