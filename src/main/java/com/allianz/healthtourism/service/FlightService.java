package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.repository.PlaneRepository;
import com.allianz.healthtourism.database.specification.FlightSpecification;
import com.allianz.healthtourism.exceptions.RecordNotFoundException;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.requestDTO.flight.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.FlightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    @Autowired
    PlaneRepository planeRepository;

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

    public Boolean addPlaneToFlight(UUID flightUuid, UUID planeUuid) {
        FlightEntity flight = flightRepository.findByUuid(flightUuid).orElse(null);
        PlaneEntity plane = planeRepository.findByUuid(planeUuid).orElse(null);
        if(flight == null){
            throw new RecordNotFoundException("Flight is nout found!");
        }
        if(plane == null){
            throw new RecordNotFoundException("Plane is nout found!");
        }
        flight.setPlane(plane);
        flightRepository.save(flight);
        return Boolean.TRUE;
    }
}
