package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.database.repository.PlaneRepository;
import com.allianz.healthtourism.database.specification.PlaneSpecification;
import com.allianz.healthtourism.mapper.PlaneMapper;
import com.allianz.healthtourism.model.requestDTO.plane.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService extends BaseService<
        PlaneEntity,
        PlaneDTO,
        PlaneRequestDTO,
        PlaneMapper,
        PlaneRepository,
        PlaneSpecification> {

    @Autowired
    PlaneMapper planeMapper;
    @Autowired
    PlaneRepository planeRepository;
    @Autowired
    PlaneSpecification planeSpecification;

    @Override
    protected PlaneMapper getMapper() {
        return planeMapper;
    }

    @Override
    protected PlaneRepository getRepository() {
        return planeRepository;
    }

    @Override
    protected PlaneSpecification getSpecification() {
        return planeSpecification;
    }
}
