package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.specification.FlightSpecification;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.FlightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<
        FlightEntity,
        FlightDTO,
        FlightRequestDTO,
        FlightMapper,
        FlightRepository,
        FlightSpecification> {

    @Autowired
    FlightMapper flightMapper;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightSpecification flightSpecification;

    @Override
    protected FlightMapper getMapper() {
        return flightMapper;
    }

    @Override
    protected FlightRepository getRepository() {
        return flightRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return flightSpecification;
    }
}
