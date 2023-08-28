package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.database.repository.ReservationRepository;
import com.allianz.healthtourism.database.specification.ReservationSpecification;
import com.allianz.healthtourism.mapper.ReservationMapper;
import com.allianz.healthtourism.model.requestDTO.reservation.ReservationRequestDTO;
import com.allianz.healthtourism.model.responseDTO.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends BaseService<
        ReservationEntity,
        ReservationDTO,
        ReservationRequestDTO,
        ReservationMapper,
        ReservationRepository,
        ReservationSpecification> {

    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservationSpecification reservationSpecification;

    @Override
    protected ReservationMapper getMapper() {
        return reservationMapper;
    }

    @Override
    protected ReservationRepository getRepository() {
        return reservationRepository;
    }

    @Override
    protected ReservationSpecification getSpecification() {
        return reservationSpecification;
    }
}
