package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.specification.FlightSpecification;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.FlightDTO;
import com.allianz.healthtourism.service.FlightService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<
        FlightEntity,
        FlightDTO,
        FlightRequestDTO,
        FlightMapper,
        FlightRepository,
        FlightSpecification,
        FlightService> {

    @Autowired
    FlightService flightService;

    @Override
    protected FlightService getService() {
        return flightService;
    }

    // Add plane to flight
    // Add reservation to flight


}
