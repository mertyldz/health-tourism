package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.specification.FlightSpecification;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.requestDTO.flight.FlightAddPlaneRequestDTO;
import com.allianz.healthtourism.model.requestDTO.flight.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.FlightDTO;
import com.allianz.healthtourism.service.FlightService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("add-plane")
    public ResponseEntity<Boolean> addPlaneToFlight(@RequestBody FlightAddPlaneRequestDTO flightAddPlaneRequestDTO){
        return new ResponseEntity<>(flightService.addPlaneToFlight(
                flightAddPlaneRequestDTO.getFlightUuid(),flightAddPlaneRequestDTO.getPlaneUuid()),
                HttpStatus.OK);
    }
}
