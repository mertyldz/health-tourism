package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.database.repository.ReservationRepository;
import com.allianz.healthtourism.database.specification.ReservationSpecification;
import com.allianz.healthtourism.mapper.ReservationMapper;
import com.allianz.healthtourism.model.requestDTO.ReservationRequestDTO;
import com.allianz.healthtourism.model.responseDTO.ReservationDTO;
import com.allianz.healthtourism.service.ReservationService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class ReservationController extends BaseController<
        ReservationEntity,
        ReservationDTO,
        ReservationRequestDTO,
        ReservationMapper,
        ReservationRepository,
        ReservationSpecification,
        ReservationService> {

    @Autowired
    ReservationService reservationService;

    @Override
    protected ReservationService getService() {
        return reservationService;
    }

}
