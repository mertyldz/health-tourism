package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.ExaminationEntity;
import com.allianz.healthtourism.database.repository.ExaminationRepository;
import com.allianz.healthtourism.database.specification.ExaminationSpecification;
import com.allianz.healthtourism.mapper.ExaminationMapper;
import com.allianz.healthtourism.model.requestDTO.examination.ExaminationRequestDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationDTO;
import com.allianz.healthtourism.service.ExaminationService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("examination")
public class ExaminationController extends BaseController<
        ExaminationEntity,
        ExaminationDTO,
        ExaminationRequestDTO,
        ExaminationMapper,
        ExaminationRepository,
        ExaminationSpecification,
        ExaminationService> {

    @Autowired
    ExaminationService examinationService;

    @Override
    protected ExaminationService getService() {
        return examinationService;
    }
}
