package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.database.repository.PlaneRepository;
import com.allianz.healthtourism.database.specification.PlaneSpecification;
import com.allianz.healthtourism.mapper.PlaneMapper;
import com.allianz.healthtourism.model.requestDTO.plane.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneDTO;
import com.allianz.healthtourism.service.PlaneService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plane")
public class PlaneController extends BaseController<
        PlaneEntity,
        PlaneDTO,
        PlaneRequestDTO,
        PlaneMapper,
        PlaneRepository,
        PlaneSpecification,
        PlaneService> {

    @Autowired
    PlaneService planeService;

    @Override
    protected PlaneService getService() {
        return planeService;
    }

}
