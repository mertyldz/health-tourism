package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.ExaminationEntity;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.database.repository.ExaminationRepository;
import com.allianz.healthtourism.database.specification.DoctorSpecification;
import com.allianz.healthtourism.database.specification.ExaminationSpecification;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.mapper.ExaminationMapper;
import com.allianz.healthtourism.model.requestDTO.ExaminationRequestDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminationService extends BaseService<
        ExaminationEntity,
        ExaminationDTO,
        ExaminationRequestDTO,
        ExaminationMapper,
        ExaminationRepository,
        ExaminationSpecification> {

    @Autowired
    ExaminationMapper examinationMapper;
    @Autowired
    ExaminationRepository examinationRepository;
    @Autowired
    ExaminationSpecification examinationSpecification;

    @Override
    protected ExaminationMapper getMapper() {
        return examinationMapper;
    }

    @Override
    protected ExaminationRepository getRepository() {
        return examinationRepository;
    }

    @Override
    protected ExaminationSpecification getSpecification() {
        return examinationSpecification;
    }
}
