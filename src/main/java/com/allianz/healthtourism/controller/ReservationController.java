package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.database.repository.ReservationRepository;
import com.allianz.healthtourism.database.specification.ReservationSpecification;
import com.allianz.healthtourism.mapper.ReservationMapper;
import com.allianz.healthtourism.model.requestDTO.reservation.*;
import com.allianz.healthtourism.model.responseDTO.ReservationDTO;
import com.allianz.healthtourism.service.ReservationService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("add-hospital")
    public ResponseEntity<Boolean> addHospitalToReservation(@RequestBody ReservationAddHospitalRequestDTO
                                                                    addHospitalRequestDTO) {
        return new ResponseEntity<>(reservationService.addHospitalToReservation(
                addHospitalRequestDTO.getReservationUuid(), addHospitalRequestDTO.getHospitalUuid()),
                HttpStatus.OK);
    }

    @PostMapping("add-flight")
    public ResponseEntity<Boolean> addFlightToReservation(@RequestBody ReservationAddFlightRequestDTO
                                                                  addFlightRequestDTO) {
        return new ResponseEntity<>(reservationService.addFlightToReservation(
                addFlightRequestDTO.getReservationUuid(), addFlightRequestDTO.getFlightUuid()),
                HttpStatus.OK);
    }

    @PostMapping("add-hotel")
    public ResponseEntity<Boolean> addHotelToReservation(@RequestBody ReservationAddHotelRequestDTO
                                                                 addHotelRequestDTO) {
        return new ResponseEntity<>(reservationService.addHotelToReservation(
                addHotelRequestDTO.getReservationUuid(), addHotelRequestDTO.getHotelUuid()),
                HttpStatus.OK);
    }

    @PostMapping("add-doctor")
    public ResponseEntity<Boolean> addDoctorToReservation(@RequestBody ReservationAddDoctorRequestDTO
                                                                  addDoctorRequestDTO) {
        return new ResponseEntity<>(reservationService.addDoctorToReservation(
                addDoctorRequestDTO.getReservationUuid(), addDoctorRequestDTO.getDoctorUuid()),
                HttpStatus.OK);
    }
    @PostMapping("make-payment")
    public ResponseEntity<Boolean> makePayment(@RequestBody ReservationPaymentRequestDTO reservationPaymentRequestDTO){
        return new ResponseEntity<>(reservationService.makePayment(reservationPaymentRequestDTO.getReservationUuid()),
                HttpStatus.OK);
    }

    @PostMapping("approve-reservation")
    public ResponseEntity<Boolean> approveReservation(@RequestBody ReservationApproveRequestDTO approveRequestDTO){
        return new ResponseEntity<>(reservationService.approveReservation(approveRequestDTO.getReservationUuid()),
                HttpStatus.OK);
    }

}
